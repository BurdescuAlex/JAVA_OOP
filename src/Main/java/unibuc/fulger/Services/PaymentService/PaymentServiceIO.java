package unibuc.fulger.Services.PaymentService;


import unibuc.fulger.Model.Payment.Card;
import unibuc.fulger.Model.Payment.Cash;
import unibuc.fulger.Model.Payment.Payment;
import unibuc.fulger.Model.Products.Products;
import unibuc.fulger.Model.ShoppingCart.ShoppingCart;
import unibuc.fulger.Services.AuditService;
import unibuc.fulger.Services.ProductService.ProductService;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class PaymentServiceIO {

    private static PaymentServiceIO instance = new PaymentServiceIO();
    private static String cashPath = "src/Data/CashPayment.csv";
    private static String cardPath = "src/Data/CardPayment.csv";
    private SimpleDateFormat toDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    private Vector<Payment> paymentsVector = new Vector<Payment>();
    private AuditService auditService = AuditService.getInstance();

    private PaymentServiceIO () {}

    public static PaymentServiceIO getInstance() {
        return instance;
    }

    public Vector<Payment> ReadData(ProductService productService)
    {
        auditService.writeLog("ENTER PaymentServiceIO ReadData");
        Path cashFile = Paths.get(cashPath);
        Path cardFile = Paths.get(cardPath);

        try {
            var inputCash = Files.readAllLines(cashFile);
            var inputCard = Files.readAllLines(cardFile);

            /// tokens[0] PaymentID Id

            for (String line : inputCash) {
                String[] tokens = line.split(",");

                Date paymentDate = toDate.parse(tokens[1]);
                double payed = Double.parseDouble(tokens[2]);
                ShoppingCart cart = new ShoppingCart();
                for(int i=6 ; i<tokens.length ; i++)
                {
                    cart.buy(productService.findProduct(Integer.parseInt(tokens[i])));
                }
                ///Cash Reader: PaymentDate, Price , ShoppingCart
                Cash X= new Cash(cart,payed);
                X.setDate(paymentDate);
                paymentsVector.add(X);
            }
            for (String line : inputCard) {
                String[] tokens = line.split(",");

                Date paymentDate = toDate.parse(tokens[1]);
                int cardNumber = Integer.parseInt(tokens[2]);
                ShoppingCart cart = new ShoppingCart();
                for(int i=5 ; i<tokens.length ; i++)
                {
                    cart.buy(productService.findProduct(Integer.parseInt(tokens[i])));
                }
                ///Card Reader: CardNumber, ShoppingCart
                Card X= new Card(cart,cardNumber);
                X.setDate(paymentDate);
                paymentsVector.add(X);
            }
            auditService.writeLog("EXIT PaymentServiceIO ReadData");
        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return paymentsVector;
    }

    public void WriteData(Vector<Payment> payments)
    {
        auditService.writeLog("ENTER PaymentServiceIO WriteData");
        Path cashFile = Paths.get(cashPath);
        Path cardFile = Paths.get(cardPath);

        try {
            var outputCash = Files.newBufferedWriter(cashFile);
            var outputCard = Files.newBufferedWriter(cardFile);
            var output = outputCard;
            for( Payment pay : payments) {
                if(pay instanceof Cash){
                    outputCash.write( pay.getId() + "," +pay.getDate() + "," + ((Cash) pay).getPayed() + "," + ((Cash) pay).getToPay() + "," + ((Cash) pay).getRest() + ",Bought");
                    output=outputCash;
                }
                if(pay instanceof Card){
                    outputCard.write( pay.getId() + "," +pay.getDate() + "," + ((Card) pay).getCardNumber() + "," + ((Card) pay).getPayed() + ",Bought");
                    output=outputCard;
                }
                for(Products p : pay.getCart().getCart()){
                    output.write( "," + p.getProductID());
                }
                output.write("\n");
            }
            outputCash.flush();
            outputCard.flush();
            output.flush();
            auditService.writeLog("EXIT PaymentServiceIO WriteData");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
