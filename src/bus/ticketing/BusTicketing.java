/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.ticketing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 *
 * @author Yousaf
 */
public class BusTicketing extends JFrame {

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    JFrame f = new JFrame("Daewoo Bus Ticketing");
    JLabel usrnamelbl = new JLabel(" User Name :");
    JLabel passwordlbl = new JLabel(" Password :");
    JTextField userInput = new JTextField();
    JPasswordField passInput = new JPasswordField();
    JButton btnLogin = new JButton("Log In");
    ImageIcon logo = new ImageIcon("daewoo.jpg");
    JLabel Imagelbl;

    BusTicketing() {
        WindowUtilities.setNativeLookAndFeel();
        //panel.setBounds(200,300,300,300);
        f.setSize(700, 600);
        f.setLayout(null);

        f.setForeground(Color.yellow);
        Imagelbl = new JLabel(logo);
        userInput.setBounds(300, 340, 150, 20);
        passInput.setBounds(300, 370, 150, 20);
        usrnamelbl.setBounds(200, 340, 100, 10);
        passwordlbl.setBounds(200, 370, 100, 10);
        Imagelbl.setBounds(180, 15, 300, 300);
        btnLogin.setBounds(290, 410, 80, 30);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userInput.getText().toString();
                String password = new String(passInput.getPassword());

                try {
                    createConnection();
                    resultSet = statement.executeQuery("Select username, password from ROOT.user_table"
                            + " where username='" + username + "' and password='" + password + "'");
                    String user = "", pass = "";
                    if (resultSet.next()) {
                        user = resultSet.getString(1);
                        pass = resultSet.getString(2);
                    }

                    if (username.equals(user) && password.equals(pass)) {
                        BookingInterface b2 = new BookingInterface();
                        
                        JOptionPane.showMessageDialog(null, "Successfully Logged in");
                        f.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Username/password isn't correct");
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });

        f.add(btnLogin);
        f.add(Imagelbl);
        f.add(usrnamelbl);
        f.add(passwordlbl);
        f.add(userInput);
        f.add(passInput);
        f.setVisible(true);

    }

  
    public static void main(String[] args) {
        BusTicketing b1 = new BusTicketing();

    }

    void createConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Bus", "root", "root");
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
