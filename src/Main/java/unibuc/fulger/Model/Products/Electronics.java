package unibuc.fulger.Model.Products;

public class Electronics extends Products {
    private int warrantyTime;
    private double deliveryPrice;

    public Electronics(String productName, double productPrice, int warrantyTime, double deliveryPrice) {
        super(productName, productPrice);
        this.warrantyTime = warrantyTime;
        this.deliveryPrice = deliveryPrice;
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(int warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public double getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    @Override
    public String toString() {
        return super.toString() + " is " + "Electronics{" +
                "warrantyTime=" + warrantyTime +
                ", deliveryPrice=" + deliveryPrice +
                '}';
    }
}
