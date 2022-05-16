package Presentation;

import DAL.FileSplit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class MainGUI extends JFrame {
    public JLabel userLable, passwordLable, registerLable, orLable;
    public JTextField usernameText, passwordText;
    public JTextField firstName, lastName, pass, email;
    public JButton logBut, regBut;
    public JPanel contentPane;
    public JPasswordField passwordField;

    public MainGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 255, 280);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(255, 230, 255));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("LOGIN");
        lblNewUserRegister.setForeground(Color.red);
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewUserRegister.setBounds(85, 10, 325, 50);
        contentPane.add(lblNewUserRegister);

        userLable = new JLabel("Username");
        userLable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        userLable.setBounds(25, 70,100,20);
        contentPane.add(userLable);

        passwordLable = new JLabel("Password");
        passwordLable.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordLable.setBounds(25, 100,100,20);
        contentPane.add(passwordLable);

        usernameText = new JTextField(10);
        usernameText.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        usernameText.setBounds(120,70,100,20);
        contentPane.add(usernameText);

        passwordField = new JPasswordField(10);
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        passwordField.setBounds(120,100,100,20);
        contentPane.add(passwordField);

        logBut = new JButton("Sign In");
        logBut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        logBut.setBounds(25, 130, 194, 23);
        logBut.setBackground(Color.red);
        logBut.setForeground(new Color(250,250,250));
        contentPane.add(logBut);

        orLable = new JLabel("OR");
        orLable.setFont(new Font("Tahoma", Font.PLAIN, 15));
        orLable.setBounds(110, 155, 20, 20);
        contentPane.add(orLable);

        regBut = new JButton("Register");
        regBut.setFont(new Font("Tahoma", Font.PLAIN, 14));
        regBut.setBounds(25,180 , 194, 23);
        regBut.setBackground(Color.red);
        regBut.setForeground(new Color(250,250,250));
        contentPane.add(regBut);
    }

}
