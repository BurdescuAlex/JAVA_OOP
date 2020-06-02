package unibuc.fulger;
import unibuc.fulger.Model.Payment.Card;
import unibuc.fulger.Model.Payment.Cash;
import unibuc.fulger.Model.Payment.Payment;
import unibuc.fulger.Model.Products.*;
import unibuc.fulger.Model.Employees.*;
import unibuc.fulger.Model.ShoppingCart.ShoppingCart;
import unibuc.fulger.Services.AuditService;
import unibuc.fulger.Services.EmployeesService.EmployeeService;
import unibuc.fulger.Services.EmployeesService.EmployeeServiceIO;
import unibuc.fulger.Services.PaymentService.PaymentService;
import unibuc.fulger.Services.PaymentService.PaymentServiceIO;
import unibuc.fulger.Services.ProductService.ProductService;
import unibuc.fulger.Services.ProductService.ProductServiceIO;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat toDate = new SimpleDateFormat("dd-MM-yyyy");

        //Initialize the Services
        ProductService productService = ProductService.getInstance();
        EmployeeService employeeService = EmployeeService.getInstance();
        PaymentService paymentService = PaymentService.getInstance();

        //Initialize the Read/Write Services
        ProductServiceIO productServiceIO = ProductServiceIO.getInstance();
        EmployeeServiceIO employeeServiceIO = EmployeeServiceIO.getInstance();
        PaymentServiceIO paymentServiceIO = PaymentServiceIO.getInstance();
        AuditService auditService = AuditService.getInstance();

        //Read the Data
        auditService.writeSession();
        productService.addProduct(productServiceIO.ReadData());
        employeeService.addEmployees(employeeServiceIO.ReadData());
        employeeService.addFiredEmployees(employeeServiceIO.ReadFired());
        paymentService.addPayments(paymentServiceIO.ReadData(productService));



        System.out.println("/////////////////TEST PRODUCTS//////////////////");
//        productService.addProduct(new Food("Para", 3, toDate.parse("20-08-2019")));
        productService.addProduct(new Electronics("SSD", 150, 2, 15));
//        productService.addProduct(new Furniture("Fotoliu", 125, 25, true));
//
        productService.removeProduct(9);
        System.out.println(productService.seeProducts());




        System.out.println("/////////////////TEST EMPLOYEES///////////////");
//        employeeService.addEmployee(new Cashier("Gabi", 2500, 30));
//        employeeService.addEmployee(new CashRegisterSpecialist("Jon", 3500, "Jon12345", "12345678"));
//        employeeService.addEmployee(new Cashier("Ionut", 2500, 2));

//        employeeService.fireEmployee(8,"Was not coming to work");
        System.out.println( "Actual:\n" + employeeService.seeEmployees());
        System.out.println( "Fired:\n" + employeeService.seeFiredEmployees());




        System.out.println("///////////////TEST PAYMENTS/////////////////");
//        ShoppingCart cart = new ShoppingCart();
//        cart.buy(productService.findProduct(1));
//        cart.buy(productService.findProduct(3));
//
//        paymentService.addPayment(new Cash(cart, cart.price()+10));
//
//        cart.emptyCart();
//
//        cart.buy(productService.findProduct(2));
//        cart.buy(productService.findProduct(5));
//
//        paymentService.addPayment(new Card(cart,32154321));
        System.out.println(paymentService.seePayments());



        System.out.println("///////////////TEST PRODUCT DATA/////////////////");

        productServiceIO.WriteData(productService.getProducts());
        employeeServiceIO.WriteData(employeeService.getEmployees(), employeeService.getFiredEmployees());
        paymentServiceIO.WriteData(paymentService.getPayments());

    }
}

