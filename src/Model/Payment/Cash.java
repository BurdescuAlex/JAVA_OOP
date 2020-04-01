package Model.Payment;

import Model.ShoppingCart.ShoppingCart;

import java.text.ParseException;

public class Cash extends Payment {
    double toPay;
    double rest;
    double payed;

    public Cash(ShoppingCart cart, double payed) throws ParseException {
        super(cart);
        this.payed = payed;
        this.toPay = super.getCart().price();
        this.rest = payed - toPay;
    }

    public double getToPay() {
        return toPay;
    }

    public void setToPay(double toPay) {
        this.toPay = toPay;
    }

    public double getRest() {
        return rest;
    }

    public void setRest(double rest) {
        this.rest = rest;
    }

    public double getPayed() {
        return payed;
    }

    public void setPayed(double payed) {
        this.payed = payed;
    }

    @Override
    public String toString() {
        return  super.toString() + "  Cash{" +
                "toPay=" + toPay +
                ", rest=" + rest +
                ", payed=" + payed +
                '}';
    }
}
