package unibuc.fulger.Repository.ProductRepository;
import unibuc.fulger.Model.Products.*;

import java.sql.SQLException;
import java.util.Vector;
import unibuc.fulger.Services.ProductService.ProductServiceIO;

public class ProductRepository {

    private Vector<Products> productList = new Vector<Products>();
    private ProductServiceIO productServiceIO = ProductServiceIO.getInstance();

    public ProductRepository(){

    }
    public ProductRepository(Vector<Products> productList) {
        this.productList = productList;
    }

    public void add(Products P) {
        productServiceIO.WriteData(P);
    }

    public void add(Vector<Products> P) {
        productServiceIO.WriteDatas(P);
    }

    public void memory(Vector<Products> P) {
        this.productList.addAll(P);
    }

    public void removeProductById(int id) throws SQLException {
        System.out.println("Removed product with id " + id);
        productServiceIO.deleteProduct(id);
    }

    public void changeProductNameById(int id, String name) throws SQLException {
        productServiceIO.changeName(id,name);
    }

    public Products findProductById(int id) {
        for(Products product : productList)
            if (product.getProductID() == id) {
                return product;
            }
        return null;
    }

    public Vector<Products> getProducts()
    {
        return productList;
    }
}
