package Services.ProductService;
import Model.Products.Products;
import Repository.ProductRepository.ProductRepository;
import java.util.Vector;

public class ProductService {

    private static ProductService instance = new ProductService();
    private ProductRepository productRepository = new ProductRepository();

    private ProductService() {

    }

    public static ProductService getInstance() {
        return instance;
    }

    public void addProduct(Products P) {
        productRepository.add(P);
    }

    public Products findProduct(int id) {
        return productRepository.findProductById(id);
    }

    public Vector<Products> getProducts() {
        return productRepository.getProducts();
    }

    public void removeProduct(int id)
    {
        productRepository.removeProductById(id);
    }

    public String seeProducts() {
        String Output="";
        Vector<Products> productList = productRepository.getProducts();
        for(Products product : productList){
            Output = Output + product.toString() + "\n";
        }
        return Output;
    }
}
