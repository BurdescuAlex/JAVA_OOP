package Main;
import Model.Payment.Card;
import Model.Payment.Cash;
import Model.Payment.Payment;
import Model.Products.*;
import Model.Employees.*;
import Model.ShoppingCart.ShoppingCart;
import Services.EmployeesService.EmployeeService;
import Services.PaymentService.PaymentService;
import Services.ProductService.ProductService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat toDate = new SimpleDateFormat("dd-mm-yyyy");


        ProductService productService = ProductService.getInstance();
        EmployeeService employeeService = EmployeeService.getInstance();
        PaymentService paymentService = PaymentService.getInstance();


        System.out.println("/////////////////TEST PRODUCTS//////////////////");
        productService.addProduct(new Food("Mar", 3, toDate.parse("20-08-2019")));
        productService.addProduct(new Electronics("Laptop", 150, 2, 15));
        productService.addProduct(new Furniture("Birou", 125, 25, true));

        productService.removeProduct(2);
        System.out.println(productService.seeProducts());


        System.out.println("/////////////////TEST EMPLOYEES///////////////");
        employeeService.addEmployee(new Cashier("Gabi", 2500, 30));
        employeeService.addEmployee(new CashRegisterSpecialist("Mihai", 3500, "Mihai12345", "12345678"));
        employeeService.addEmployee(new Cashier("Ana", 2500, 2));

        employeeService.fireEmployee(2,"Was not coming to work");
        System.out.println(employeeService.seeEmployees());
        System.out.println(employeeService.seeFiredEmployees());

        System.out.println("///////////////TEST PAYMENTS/////////////////");
        ShoppingCart cart = new ShoppingCart();
        cart.buy(productService.findProduct(1));
        cart.buy(productService.findProduct(3));

        paymentService.addPayment(new Cash(cart, cart.price()+10));

        cart.emptyCart();

        cart.buy(productService.findProduct(3));
        cart.buy(new Food("Para", 1, toDate.parse("21-4-2020")));

        paymentService.addPayment(new Card(cart,32154321));
        System.out.println(paymentService.seePayments());

    }
}

