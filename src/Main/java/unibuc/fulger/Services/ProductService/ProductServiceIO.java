package unibuc.fulger.Services.ProductService;
import unibuc.fulger.Model.Products.Electronics;
import unibuc.fulger.Model.Products.Food;
import unibuc.fulger.Model.Products.Furniture;
import unibuc.fulger.Model.Products.Products;
import unibuc.fulger.Services.AuditService;
import unibuc.fulger.Services.DBconnection;

import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class ProductServiceIO {

    private static ProductServiceIO instance = new ProductServiceIO();
    private Vector<Products> productsVector = new Vector<Products>();
    private SimpleDateFormat toDate = new SimpleDateFormat("yyyy-MM-dd");
    private AuditService auditService = AuditService.getInstance();
    private Connection connection = DBconnection.getDBConnection();

    private ProductServiceIO () {}

    public static ProductServiceIO getInstance() {
        return instance;
    }

    public Vector<Products> ReadData()
    {
        auditService.writeLog("ENTER ProductServiceIO ReadData");


        try {

            String sqlSelect = "SELECT * FROM products";
            PreparedStatement statement =  connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())    {
                if(resultSet.getString(2).equals("Food"))
                    //Food Reader: Name, Price , Expire Date
                    productsVector.add(new Food(resultSet.getString(3), resultSet.getDouble(4), toDate.parse(String.valueOf(resultSet.getDate(5)))));
                if(resultSet.getString(2).equals("Electronics"))
                    ///Electronics Reader: Name, Price, Warranty Time , Delivery Price
                    productsVector.add(new Electronics(resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(6), resultSet.getDouble(7)));
                if(resultSet.getString(2).equals("Furniture"))
                    ///Furniture Reader: Name, Price, Delivery Price, Deliverable
                    productsVector.add(new Furniture(resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(7), resultSet.getBoolean(8)));
            }
            auditService.writeLog("EXIT ProductServiceIO ReadData");

        }
        catch (ParseException | SQLException e) {
            e.printStackTrace();
        }
        return productsVector;
    }

    // For writing multiple products
    public void WriteDatas(Vector<Products> products)
    {
        auditService.writeLog("ENTER ProductServiceIO WriteDatas");

        try {
            for( Products p : products) {
                if(p instanceof Food){

                    String sqlAdd = "INSERT INTO products (`type`, `Name`, `Price`, `ExpireDate`) VALUES (?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1, "Food");
                    statement.setString(2, p.getProductName());
                    statement.setDouble(3, p.getProductPrice());

                    java.sql.Date x = new Date(((Food) p).getExpireDate().getTime());
                    statement.setDate(4, x);

                    statement.executeUpdate();

                }
                if(p instanceof Electronics){

                    String sqlAdd = "INSERT INTO products (`type`, `Name`, `Price`, `WarrentyTime`, `DeliveryPrice`) VALUES (?,?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1, "Electronics");
                    statement.setString(2, p.getProductName());
                    statement.setDouble(3, p.getProductPrice());
                    statement.setInt(4, ((Electronics) p).getWarrantyTime());
                    statement.setDouble(5, ((Electronics) p).getDeliveryPrice());

                    statement.executeUpdate();

                }
                if(p instanceof Furniture){

                    String sqlAdd = "INSERT INTO products (`type`, `Name`, `Price`, `DeliveryPrice`, `Wantdelivery`) VALUES (?,?,?,?,?)";
                    PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                    statement.setString(1, "Furniture");
                    statement.setString(2, p.getProductName());
                    statement.setDouble(3, p.getProductPrice());
                    statement.setDouble(4, ((Furniture) p).getDeliveryPrice());
                    statement.setString(5, String.valueOf(((Furniture) p).isWantDelivery()));

                    statement.executeUpdate();

                }
            }

            auditService.writeLog("EXIT ProductServiceIO WriteDatas");
        }
        catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    // to write only one product
    public void WriteData(Products p)
    {
        auditService.writeLog("ENTER ProductServiceIO WriteData");

        try {
            if(p instanceof Food){

                String sqlAdd = "INSERT INTO products (`type`, `Name`, `Price`, `ExpireDate`) VALUES (?,?,?,?)";
                PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                statement.setString(1, "Food");
                statement.setString(2, p.getProductName());
                statement.setDouble(3, p.getProductPrice());

                java.sql.Date x = new Date(((Food) p).getExpireDate().getTime());
                statement.setDate(4, x);

                statement.executeUpdate();

            }
            if(p instanceof Electronics){

                String sqlAdd = "INSERT INTO products (`type`, `Name`, `Price`, `WarrentyTime`, `DeliveryPrice`) VALUES (?,?,?,?,?)";
                PreparedStatement statement =  connection.prepareStatement(sqlAdd);

                statement.setString(1, "Electronics");
                statement.setString(2, p.getProductName());
                statement.setDouble(3, p.getProductPrice());
                statement.setInt(4, ((Electronics) p).getWarrantyTime());
                statement.setDouble(5, ((Electronics) p).getDeliveryPrice());

                statement.executeUpdate();

            }
            if(p instanceof Furniture) {

                String sqlAdd = "INSERT INTO products (`type`, `Name`, `Price`, `DeliveryPrice`, `Wantdelivery`) VALUES (?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(sqlAdd);

                statement.setString(1, "Furniture");
                statement.setString(2, p.getProductName());
                statement.setDouble(3, p.getProductPrice());
                statement.setDouble(4, ((Furniture) p).getDeliveryPrice());
                statement.setString(5, String.valueOf(((Furniture) p).isWantDelivery()));

                statement.executeUpdate();
            }

            auditService.writeLog("EXIT ProductServiceIO WriteData");
        }
        catch ( SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int idProduct) throws SQLException {
        auditService.writeLog("ENTER ProductServiceIO deleteProduct");
        String sqlDelete = "DELETE FROM products WHERE id = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlDelete);
        statement.setInt(1, idProduct);
        statement.executeUpdate();
        auditService.writeLog("Exit ProductServiceIO deleteProduct");
    }

    public void changeName(int id, String newName) throws SQLException {
        auditService.writeLog("ENTER ProductServiceIO changeName");
        String sqlUpdate = "UPDATE products SET name = ? WHERE id = ?";
        PreparedStatement statement =  connection.prepareStatement(sqlUpdate);
        statement.setString(1, newName);
        statement.setInt(2, id);
        statement.executeUpdate();
        auditService.writeLog("EXIT ProductServiceIO changeName");
    }
}

