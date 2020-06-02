package unibuc.fulger.Services.ProductService;
import unibuc.fulger.Model.Products.Products;
import unibuc.fulger.Repository.ProductRepository.ProductRepository;
import unibuc.fulger.Services.AuditService;

import java.util.Vector;

public class ProductService {

    private static ProductService instance = new ProductService();
    private ProductRepository productRepository = new ProductRepository();
    private AuditService auditService = AuditService.getInstance();

    private ProductService() {

    }

    public static ProductService getInstance() {
        return instance;
    }

    public void addProduct(Products P) {
        auditService.writeLog("addProduct");
        productRepository.add(P);
    }
    public void addProduct(Vector<Products> P) {
        auditService.writeLog("addProduct");
        productRepository.add(P);
    }

    public Products findProduct(int id) {
        auditService.writeLog("findProduct");
        return productRepository.findProductById(id);
    }

    public Vector<Products> getProducts() {
        auditService.writeLog("getProducts");
        return productRepository.getProducts();
    }

    public void removeProduct(int id)
    {
        auditService.writeLog("removeProduct");
        productRepository.removeProductById(id);
    }

    public String seeProducts() {
        auditService.writeLog("seeProducts");
        String Output="";
        Vector<Products> productList = productRepository.getProducts();
        for(Products product : productList){
            Output = Output + product.toString() + "\n";
        }
        return Output;
    }
}
