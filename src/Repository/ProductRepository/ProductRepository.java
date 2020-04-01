package Repository.ProductRepository;
import Model.Products.*;
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

    public void removeProductById(int id)
    {
        for (Products product : productList){
            if ( product.getProductID() == id)
            {
                System.out.println("Removed: "+product.toString());
                productList.remove(product);
            }
        }
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
