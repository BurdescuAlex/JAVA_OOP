package unibuc.fulger.Repository.ProductRepository;
import unibuc.fulger.Model.Products.*;
import java.util.Vector;

public class ProductRepository {

    private Vector<Products> productList = new Vector<Products>();

    public ProductRepository(){

    }
    public ProductRepository(Vector<Products> productList) {
        this.productList = productList;
    }

    public void add(Products P) {
        this.productList.add(P);
    }

    public void add(Vector<Products> P) {
        this.productList.addAll(P);
    }

    public void removeProductById(int id)
    {
        for(Products p : productList)
        {
            if(p.getProductID() == id){
                System.out.println("Removed: " + p.toString());
            }
        }
        productList.removeIf(p -> p.getProductID() == id);
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
