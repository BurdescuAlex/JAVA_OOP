package unibuc.fulger.Model.Products;

public class Furniture extends Products {
    private int deliveryPrice;
    private boolean wantDelivery;

    public Furniture(String productName, double productPrice, int deliveryPrice, boolean wantDelivery) {
        super(productName, productPrice);
        this.deliveryPrice = deliveryPrice;
        this.wantDelivery = wantDelivery;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(int deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public boolean isWantDelivery() {
        return wantDelivery;
    }

    public void setWantDelivery(boolean wantDelivery) {
        this.wantDelivery = wantDelivery;
    }

    @Override
    public String toString() {
        return super.toString() + " is " + "Furniture{" +
                "deliveryPrice=" + deliveryPrice +
                ", wantDelivery=" + wantDelivery +
                '}';
    }
}
