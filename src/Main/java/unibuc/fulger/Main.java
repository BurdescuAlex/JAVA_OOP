package unibuc.fulger;
import unibuc.fulger.Model.Payment.Card;
import unibuc.fulger.Model.Payment.Cash;
import unibuc.fulger.Model.Payment.Payment;
import unibuc.fulger.Model.Products.*;
import unibuc.fulger.Model.Employees.*;
import unibuc.fulger.Model.ShoppingCart.ShoppingCart;
import unibuc.fulger.Services.AuditService;
import unibuc.fulger.Services.DBconnection;
import unibuc.fulger.Services.EmployeesService.EmployeeService;
import unibuc.fulger.Services.EmployeesService.EmployeeServiceIO;
import unibuc.fulger.Services.PaymentService.PaymentService;
import unibuc.fulger.Services.PaymentService.PaymentServiceIO;
import unibuc.fulger.Services.ProductService.ProductService;
import unibuc.fulger.Services.ProductService.ProductServiceIO;
import unibuc.fulger.gui.MainFrame;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) throws ParseException, SQLException {

        SimpleDateFormat toDate = new SimpleDateFormat("dd-MM-yyyy");
        new MainFrame("Login");

        //Initialize the Services
        Connection connection = DBconnection.getDBConnection();
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
        productService.addToMemory(productServiceIO.ReadData());   // Read data from DB to memory
        employeeService.addEmployees(employeeServiceIO.ReadData()); // Read data from DB to memory
        employeeService.addFiredEmployees(employeeServiceIO.ReadFired()); // Read data from DB to memory

        paymentService.addPayments(paymentServiceIO.ReadData(productService));



        System.out.println("/////////////////TEST PRODUCTS//////////////////");

          ///ADD Products
//        productService.addProduct(new Food("Para", 3, toDate.parse("20-08-2019")));
//        productService.addProduct(new Electronics("SSD", 150, 2, 15));
//        productService.addProduct(new Furniture("Fotoliu", 125, 25, true));

          ///REMOVE products
//        productService.removeProduct(9);

          ///Update products
//        productService.changeProductNameById(10,"HDD");
        System.out.println(productService.seeProducts());




        System.out.println("/////////////////TEST EMPLOYEES///////////////");

        /// ADD to DB
//        employeeService.insertEmployeeToDB(new Cashier("AdaugatInBaza", 9500, 5));

        /// Update salary to DB
//        employeeService.updateSalaryById(30, 9999);

        /// Delete from DB
//        employeeService.deleteEmployeeById(23);

        System.out.println( "Actual:\n" + employeeService.seeEmployees());
        System.out.println( "Fired:\n" + employeeService.seeFiredEmployees());




        System.out.println("///////////////TEST PAYMENTS/////////////////");
//        ShoppingCart cart = new ShoppingCart();
//        cart.buy(productService.findProduct(1));
//        cart.buy(productService.findProduct(3));

//        paymentService.addPayment(new Cash(cart, cart.price()+10));

//        cart.emptyCart();

//        cart.buy(productService.findProduct(2));
//        cart.buy(productService.findProduct(5));

//        paymentService.addPayment(new Card(cart,32154321));
        System.out.println(paymentService.seePayments());



        System.out.println("///////////////Write everything form memory to DB/////////////////");

        /// Write to the DB all the data from Memory
        //productServiceIO.WriteDatas(productService.getProducts());
        //employeeServiceIO.WriteData(employeeService.getEmployees(), employeeService.getFiredEmployees());
       // paymentServiceIO.WriteData(paymentService.getPayments());
        DBconnection.closeDBConnection(connection);

    }
}

