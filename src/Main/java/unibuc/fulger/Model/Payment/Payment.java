package unibuc.fulger.Model.Payment;

import unibuc.fulger.Model.ShoppingCart.ShoppingCart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Payment {
    private int id;
    private static int idCounter;
    private Date date;
    private ShoppingCart cart;

    public Payment(ShoppingCart cart) throws ParseException {
        idCounter++;
        this.id = idCounter;
        this.cart = new ShoppingCart(cart.getCart());
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        this.date =  formatter.parse(formatter.format(new Date() ));;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", date=" + date +
                ", cart=" + cart +
                '}';
    }
}
