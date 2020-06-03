package unibuc.fulger.gui;

import unibuc.fulger.Model.Products.Furniture;
import unibuc.fulger.Services.ProductService.ProductService;

import javax.swing.*;

public class FurnitureFrame extends JFrame {
    private static ProductService productService = ProductService.getInstance();

    public FurnitureFrame()
    {
        super("Furniture Manager");

        JLabel nameLabel = new JLabel("Name: " );
        JTextField name = new JTextField();
        nameLabel.setBounds(20, 20, 200, 30);
        name.setBounds(180, 20, 200, 30);

        JLabel priceLabel = new JLabel("Price: " );
        JTextField price = new JTextField();
        priceLabel.setBounds(20, 60, 200, 30);
        price.setBounds(180, 60, 200, 30);

        JLabel wantDeliveryLabel = new JLabel("Deliverable? (Y/N): " );
        JTextField wantDelivery = new JTextField();
        wantDeliveryLabel.setBounds(20, 100, 200, 30);
        wantDelivery.setBounds(180, 100, 200, 30);


        JLabel deliveryLabel = new JLabel("Delivery Price (int) : " );
        JTextField delivery = new JTextField();
        deliveryLabel.setBounds(20, 140, 200, 30);
        delivery.setBounds(180, 140, 200, 30);

        JButton buttonInsert = new JButton("Insert into DB");
        buttonInsert.setBounds(205, 180, 150, 30);
        buttonInsert.addActionListener(event -> insert(name, price, wantDelivery, delivery));


        add(name);
        add(nameLabel);
        add(price);
        add(priceLabel);
        add(wantDelivery);
        add(wantDeliveryLabel);
        add(delivery);
        add(deliveryLabel);
        add(buttonInsert);


        setSize(500, 260);
        setLayout(null);
        setVisible(true);
    }
    public void insert(JTextField name, JTextField price, JTextField wantDelivery, JTextField delivery)
    {
        Boolean deliverable=false;
        String name1 = name.getText();
        Double price1 = Double.parseDouble(price.getText());
        String wantDelivery1 = wantDelivery.getText();
        Integer delivery1 = Integer.parseInt(delivery.getText());

        if(wantDelivery1.equals("Y")) {
            deliverable=true;
        }

        productService.addProduct(new Furniture(name1,price1,delivery1,deliverable));
        JOptionPane.showMessageDialog(this, "Action successful !");
    }
}

