package unibuc.fulger.gui;


import unibuc.fulger.Model.Products.Food;
import unibuc.fulger.Services.ProductService.ProductService;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodFrame extends JFrame {
    private static ProductService productService = ProductService.getInstance();

    public FoodFrame()
    {
        super("Food Manager");

        JLabel nameLabel = new JLabel("Name: " );
        JTextField name = new JTextField();
        nameLabel.setBounds(20, 20, 200, 30);
        name.setBounds(180, 20, 200, 30);

        JLabel priceLabel = new JLabel("Price: " );
        JTextField price = new JTextField();
        priceLabel.setBounds(20, 60, 200, 30);
        price.setBounds(180, 60, 200, 30);

        JLabel expireLabel = new JLabel("Expire Date (YYYY-MM-DD): " );
        JTextField expire = new JTextField();
        expireLabel.setBounds(20, 100, 200, 30);
        expire.setBounds(180, 100, 200, 30);


        JButton buttonInsert = new JButton("Insert into DB");
        buttonInsert.setBounds(205, 180, 150, 30);
        buttonInsert.addActionListener(event -> {
            try {
                insert(name, price, expire);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });


        add(name);
        add(nameLabel);
        add(price);
        add(priceLabel);
        add(expire);
        add(expireLabel);
        add(buttonInsert);


        setSize(500, 260);
        setLayout(null);
        setVisible(true);
    }
    public void insert(JTextField name, JTextField price, JTextField expire) throws ParseException {
        SimpleDateFormat toDate = new SimpleDateFormat("yyyy-MM-dd");
        String name1 = name.getText();
        Double price1 = Double.parseDouble(price.getText());
        Date expire1 = toDate.parse(expire.getText());

        java.sql.Date expire2 = new java.sql.Date(expire1.getTime());

        productService.addProduct(new Food(name1,price1,expire2));
        JOptionPane.showMessageDialog(this, "Action successful !");
    }
}

