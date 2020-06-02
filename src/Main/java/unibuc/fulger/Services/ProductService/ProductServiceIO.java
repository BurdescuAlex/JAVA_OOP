package unibuc.fulger.Services.ProductService;
import unibuc.fulger.Model.Products.Electronics;
import unibuc.fulger.Model.Products.Food;
import unibuc.fulger.Model.Products.Furniture;
import unibuc.fulger.Model.Products.Products;
import unibuc.fulger.Services.AuditService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class ProductServiceIO {

    private static ProductServiceIO instance = new ProductServiceIO();
    private static String food = "src/Data/Food.csv";
    private static String electronics = "src/Data/Electronics.csv";
    private static String furniture = "src/Data/furniture.csv";
    private Vector<Products> productsVector = new Vector<Products>();
    private SimpleDateFormat toDate = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    private AuditService auditService = AuditService.getInstance();

    private ProductServiceIO () {}

    public static ProductServiceIO getInstance() {
        return instance;
    }

    public Vector<Products> ReadData()
    {
        auditService.writeLog("ENTER ProductServiceIO ReadData");

        Path foodFile = Paths.get(food);
        Path electronicsFile = Paths.get(electronics);
        Path furnitureFile = Paths.get(furniture);

        try {
            var inputFood = Files.readAllLines(foodFile);
            var inputElectronics = Files.readAllLines(electronicsFile);
            var inputFurniture = Files.readAllLines(furnitureFile);

            /// tokens[0] Product Id

            for (String line : inputFood) {
                String[] tokens = line.split(",");

                ///Food Reader: Name, Price , Expire Date
                productsVector.add(new Food(tokens[1], Double.parseDouble(tokens[2]), toDate.parse(tokens[3])));
            }
            for (String line : inputElectronics) {
                String[] tokens = line.split(",");
                ///Electronics Reader: Name, Price, Warranty Time , Delivery Price
                productsVector.add(new Electronics(tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]), Double.parseDouble(tokens[4])));
            }
            for (String line : inputFurniture) {
                String[] tokens = line.split(",");
                ///Furniture Reader: Name, Price, Delivery Price, Deliverable
                productsVector.add(new Furniture(tokens[1], Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3]), Boolean.parseBoolean(tokens[4])));
            }

            auditService.writeLog("EXIT ProductServiceIO ReadData");

        }
        catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return productsVector;
    }
    public void WriteData(Vector<Products> products)
    {
        auditService.writeLog("ENTER ProductServiceIO WriteData");
        Path foodFile = Paths.get(food);
        Path electronicsFile = Paths.get(electronics);
        Path furnitureFile = Paths.get(furniture);

        try {
            var outputFood = Files.newBufferedWriter(foodFile);
            var outputElectronics = Files.newBufferedWriter(electronicsFile);
            var outputFurniture = Files.newBufferedWriter(furnitureFile);
            for( Products p : products) {
                if(p instanceof Food){
                    outputFood.write( p.getProductID() + "," +p.getProductName() + "," + p.getProductPrice() + "," + ((Food) p).getExpireDate() + "\n");
                }
                if(p instanceof Electronics){
                    outputElectronics.write( p.getProductID() + "," +p.getProductName() + "," + p.getProductPrice() + "," + ((Electronics) p).getWarrantyTime() + "," + ((Electronics) p).getDeliveryPrice() + "\n");
                }
                if(p instanceof Furniture){
                    outputFurniture.write( p.getProductID() + "," +p.getProductName() + "," + p.getProductPrice() + "," + ((Furniture) p).getDeliveryPrice() + "," + ((Furniture) p).isWantDelivery() + "\n");
                }
            }
            outputElectronics.flush();
            outputFood.flush();
            outputFurniture.flush();

            auditService.writeLog("EXIT ProductServiceIO WriteData");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

