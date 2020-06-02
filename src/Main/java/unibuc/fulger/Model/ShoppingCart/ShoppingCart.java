package unibuc.fulger.Model.ShoppingCart;

import unibuc.fulger.Model.Products.Products;

import java.util.Vector;

public class ShoppingCart {

    private Vector<Products> cart = new Vector<Products>();

    public ShoppingCart(Vector<Products> cart) {
        this.cart.addAll(cart);
    }
    public ShoppingCart()
    {

    }

    public Vector<Products> getCart() {
        return this.cart;
    }

    public void setCart(Vector<Products> cart) {
        this.cart.clear();
        this.cart.addAll(cart);
    }

    public void buy(Products P)
    {
        this.cart.add(P);
    }
    public double price()
    {
        double price=0;
        for(Products product : cart)
        {
            price = price + product.getProductPrice();
        }
        return price;
    }
    public void emptyCart()
    {
        this.cart.clear();
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cart=" + cart +
                '}';
    }
}
