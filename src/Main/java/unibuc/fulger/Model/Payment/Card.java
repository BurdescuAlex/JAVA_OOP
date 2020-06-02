package unibuc.fulger.Model.Payment;

import unibuc.fulger.Model.ShoppingCart.ShoppingCart;

import java.text.ParseException;

public class Card extends Payment {
    int cardNumber;
    double payed;

    public Card(ShoppingCart cart, int cardNumber) throws ParseException {
        super(cart);
        this.cardNumber = cardNumber;
        this.payed = super.getCart().price();
    }

    public int getCardNumber() {
        return this.cardNumber;
    }

    public double getPayed()
    {
        return this.payed;
    }

    @Override
    public String toString() {
        return super.toString() + "  Card{" +
                "cardNumber=" + cardNumber +
                ", payed=" + payed +
                '}';
    }
}
