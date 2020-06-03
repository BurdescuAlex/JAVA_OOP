package unibuc.fulger.gui;
import unibuc.fulger.Services.ProductService.ProductService;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class ProductFrame extends JFrame{
    private static ProductService productService = ProductService.getInstance();
    public ProductFrame(String title)
    {
        super(title);

        JButton buttonFood = new JButton("Add new Food");
        JLabel foodLable = new JLabel("Click to add new food: ");
        buttonFood.setBounds(205, 30, 150, 30);
        foodLable.setBounds(20,30, 150, 30);
        buttonFood.addActionListener(event -> openFood());

        JButton buttonElectronics = new JButton("Add new Electronics");
        JLabel electronicsLable = new JLabel("Click to add new electronics: ");
        buttonElectronics.setBounds(205, 70, 150, 30);
        electronicsLable.setBounds(20, 70, 180, 30);
        buttonElectronics.addActionListener(event -> openElectronics());

        JButton buttonFurniture = new JButton("Add new Furniture");
        JLabel furnitureLable = new JLabel("Click to add new furniture: ");
        buttonFurniture.setBounds(205, 110, 150, 30);
        furnitureLable.setBounds(20, 110, 180, 30);
        buttonFurniture.addActionListener(event -> openFurniture());

        JLabel productManager = new JLabel("GENERAL PRODUCT MANAGER");
        productManager.setBounds(180,180,300,50);


        JLabel deleteLabel = new JLabel("Id: " );
        JTextField delete = new JTextField();
        deleteLabel.setBounds(20, 220, 200, 30);
        delete.setBounds(180, 220, 200, 30);

        JButton buttonDelete = new JButton("Delete item from DB");
        buttonDelete.setBounds(205, 260, 150, 30);
        buttonDelete.addActionListener(event -> {
            try {
                delete(delete);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


        JLabel updateLabel = new JLabel("Id: " );
        JTextField update = new JTextField();
        updateLabel.setBounds(20, 300, 200, 30);
        update.setBounds(180, 300, 200, 30);

        JLabel newNameLabel = new JLabel("New Name: " );
        JTextField newName = new JTextField();
        newNameLabel.setBounds(20, 330, 200, 30);
        newName.setBounds(180, 330, 200, 30);

        JButton buttonUpdate = new JButton("Update Item Name");
        buttonUpdate.setBounds(205, 370, 150, 30);
        buttonUpdate.addActionListener(event -> {
            try {
                updateName(update,newName);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


        add(buttonFood);
        add(foodLable);
        add(buttonElectronics);
        add(electronicsLable);
        add(buttonFurniture);
        add(furnitureLable);
        add(productManager);

        add(delete);
        add(deleteLabel);
        add(buttonDelete);

        add(update);
        add(updateLabel);
        add(newName);
        add(newNameLabel);
        add(buttonUpdate);


        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
    }
    public void openElectronics()
    {
        new ElectronicsFrame();
    }
    public void openFurniture()
    {
        new FurnitureFrame();
    }
    public void openFood()
    {
        new FoodFrame();
    }
    public void delete(JTextField id) throws SQLException {

        Integer id1 = Integer.parseInt(id.getText());
        productService.removeProduct(id1);

        JOptionPane.showMessageDialog(this, "Action successful !");
    }
    public void updateName(JTextField id, JTextField newName) throws SQLException {
        Integer id1 = Integer.parseInt(id.getText());
        String newName1 = newName.getText();
        productService.changeProductNameById(id1, newName1);

        JOptionPane.showMessageDialog(this, "Action successful !");
    }
}
