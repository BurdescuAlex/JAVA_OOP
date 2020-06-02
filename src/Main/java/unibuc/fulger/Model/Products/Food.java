package unibuc.fulger.Model.Products;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Food extends Products {
    private Date expireDate;
    private boolean expired;

    public Food(String productName, double productPrice, Date expireDate) throws ParseException {
        super(productName, productPrice);
        this.expireDate = expireDate;
        setIsExpired(expireDate);
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return super.toString() + "  is  " + "Food{" +
                "expireDare=" + expireDate +
                ", expired=" + expired +
                '}';
    }

    public void setIsExpired(Date expireDate) throws ParseException {

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date todayDate = formatter.parse(formatter.format(new Date() ));
        if (expireDate.compareTo(todayDate) > 0) {
            expired=false;
        }
        else
            expired=true;
    }
}
