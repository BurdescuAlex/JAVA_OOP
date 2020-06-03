package unibuc.fulger.gui;

import unibuc.fulger.Model.Products.Electronics;
import unibuc.fulger.Services.ProductService.ProductService;

import javax.swing.*;

public class ElectronicsFrame extends JFrame {
    private static ProductService productService = ProductService.getInstance();
    public ElectronicsFrame()
    {
        super("Electronics Manager");


        JLabel nameLabel = new JLabel("Name: " );
        JTextField name = new JTextField();
        nameLabel.setBounds(20, 20, 200, 30);
        name.setBounds(180, 20, 200, 30);

        JLabel priceLabel = new JLabel("Price: " );
        JTextField price = new JTextField();
        priceLabel.setBounds(20, 60, 200, 30);
        price.setBounds(180, 60, 200, 30);

        JLabel warrantyLabel = new JLabel("Warranty Time (Years): " );
        JTextField warranty = new JTextField();
        warrantyLabel.setBounds(20, 100, 200, 30);
        warranty.setBounds(180, 100, 200, 30);


        JLabel deliveryLabel = new JLabel("Delivery Price: " );
        JTextField delivery = new JTextField();
        deliveryLabel.setBounds(20, 140, 200, 30);
        delivery.setBounds(180, 140, 200, 30);

        JButton buttonInsert = new JButton("Insert into DB");
        buttonInsert.setBounds(205, 180, 150, 30);
        buttonInsert.addActionListener(event -> insert(name, price, warranty, delivery));


        add(name);
        add(nameLabel);
        add(price);
        add(priceLabel);
        add(warranty);
        add(warrantyLabel);
        add(delivery);
        add(deliveryLabel);
        add(buttonInsert);


        setSize(500, 260);
        setLayout(null);
        setVisible(true);
    }
    public void insert(JTextField name, JTextField price, JTextField warranty, JTextField delivery)
    {
        String name1 = name.getText();
        Double price1 = Double.parseDouble(price.getText());
        Integer warranty1 = Integer.parseInt(warranty.getText());
        Double delivery1 = Double.parseDouble(delivery.getText());

        productService.addProduct(new Electronics(name1,price1,warranty1,delivery1));

        JOptionPane.showMessageDialog(this, "Action successful !");
    }
}
