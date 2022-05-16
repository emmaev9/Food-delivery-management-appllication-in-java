package Presentation;
import BLL.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

    public class RegisterGUI extends JFrame {
        //private static final long serialVersionUID = 1L;
        public JPanel contentPane;
        public JTextField firstName, lastName, username, email, number;
        public JPasswordField passwordField;
        public JButton btnNewButton;
        public JComboBox role;

        public RegisterGUI() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(450, 190, 360, 485);
            setResizable(false);
            contentPane = new JPanel();
            contentPane.setBackground(new Color(255, 230, 255));
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewUserRegister = new JLabel("Create account");
            lblNewUserRegister.setForeground(Color.red);
            lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            lblNewUserRegister.setBounds(90, 20, 325, 50);
            contentPane.add(lblNewUserRegister);

            JLabel lblName = new JLabel("First name");
            lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblName.setBounds(30, 70, 99, 43);
            contentPane.add(lblName);

            JLabel lblNewLabel = new JLabel("Last name");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblNewLabel.setBounds(30, 115, 110, 29);
            contentPane.add(lblNewLabel);

            JLabel lblEmailAddress = new JLabel("Email\r\n address");
            lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblEmailAddress.setBounds(30, 150, 110, 36);
            contentPane.add(lblEmailAddress);

            JLabel lblUsername = new JLabel("Username");
            lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblUsername.setBounds(30, 195, 99, 29);
            contentPane.add(lblUsername);

            JLabel lblPassword = new JLabel("Password");
            lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblPassword.setBounds(30, 237, 99, 24);
            contentPane.add(lblPassword);

            JLabel lblMobileNumber = new JLabel("Mobile number");
            lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lblMobileNumber.setBounds(30,280 , 139, 26);
            contentPane.add(lblMobileNumber);

            firstName = new JTextField();
            firstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
            firstName.setBounds(160, 80, 150, 25);
            contentPane.add(firstName);
            firstName.setColumns(10);

            lastName = new JTextField();
            lastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
            lastName.setBounds(160, 120, 150, 25);
            contentPane.add(lastName);
            lastName.setColumns(10);

            email = new JTextField();
            email.setFont(new Font("Tahoma", Font.PLAIN, 15));
            email.setBounds(160, 160, 150, 25);
            contentPane.add(email);
            email.setColumns(10);

            username = new JTextField();
            username.setFont(new Font("Tahoma", Font.PLAIN, 15));
            username.setBounds(160, 200, 150, 25);
            contentPane.add(username);
            username.setColumns(10);

            passwordField = new JPasswordField();
            passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
            passwordField.setBounds(160,240, 150, 25);
            contentPane.add(passwordField);

            number = new JTextField();
            number.setFont(new Font("Tahoma", Font.PLAIN, 15));
            number.setBounds(160, 280, 150, 25);
            contentPane.add(number);
            number.setColumns(10);

            String[] users = {"client","admin","employee"};
            role = new JComboBox(users);
            role.setBounds(70, 350, 200, 30);
            contentPane.add(role);

            btnNewButton = new JButton("Register");
            btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
            btnNewButton.setBounds(70, 400, 200, 30);
            btnNewButton.setBackground(Color.red);
            btnNewButton.setForeground(new Color(250,250,250));
            contentPane.add(btnNewButton);


        }
    }
