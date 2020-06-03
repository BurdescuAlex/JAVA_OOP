package unibuc.fulger.gui;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame  {
    private static String username = "admin";
    private static String password = "12345";
    private static boolean session = false;

    public MainFrame(String title)
    {
        super(title);
        JLabel nameLabel = new JLabel("Name: " );
        JTextField name = new JTextField();
        nameLabel.setBounds(20, 50, 200, 30);
        name.setBounds(90, 50, 200, 30);

        JLabel passLabel = new JLabel("Password: " );
        JTextField pass = new JTextField();
        passLabel.setBounds(20, 100, 200, 30);
        pass.setBounds(90, 100, 200, 30);

        JButton button = new JButton("Login!");
        button.setBounds(80, 150, 150, 30);
        button.addActionListener(event -> login(name, pass));

        add(name);
        add(nameLabel);
        add(pass);
        add(passLabel);
        add(button);

        setSize(350, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight()) / 2);
        while(! session)
        {
            setVisible(true);
        }
    }
    public void login( JTextField name, JTextField pass)
    {
        String name1 = name.getText();
        String pass1 = pass.getText();
        if(name1.equals(username) && pass1.equals(password))
        {
            session=true;
            JOptionPane.showMessageDialog(this, "Welcome back!");
            new ProductFrame("Product Manager");
            setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Name or Password wrong !");
        }
    }
}
