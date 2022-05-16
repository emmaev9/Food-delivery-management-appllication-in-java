package Presentation;

import BLL.BaseProduct;
import BLL.DeliveryService;
import BLL.MenuItem;
import BLL.User;
import DAL.FileSplit;
import DAL.Serializator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Controller {
    public AdminGUI adminGUI;
    public ClientGUI clientGUI;
    public RegisterGUI registerGUI;
    public MainGUI mainGUI;
    public AdminController adminController;
    public ClientController clientController;
    public EmployeeControler employeeControler;
    public HashMap<String, MenuItem> menuItemHashMap;
    public HashMap<String, MenuItem> csvHashMap;
    public Serializator serializator;
    public ArrayList<User> u;

    public DeliveryService deliveryService;

    public Controller(MainGUI mainGUI, ArrayList<User> users){

        this.mainGUI = mainGUI;
        this.registerGUI = new RegisterGUI();
        this.serializator = new Serializator();
        this.deliveryService = new DeliveryService(users);
        this.u = users;
        menuItemHashMap = deliveryService.getMenuItemHashMap();
        mainGUI.setTitle("LOGIN");
        mainGUI.setVisible(true);

        //ActionListeners for MainGUI

        mainGUI.regBut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   registerGUI.setTitle("REGISTER");
                   registerGUI.setVisible(true);
                   registerGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });

        mainGUI.logBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = mainGUI.usernameText.getText();
                String password = mainGUI.passwordField.getText();
                Boolean found = false;
                for (User user : users) {
                    if (user.userName.equals(username)) {
                        found = true;
                        if (user.password.equals(password)) {
                            if (user.role.equals("client")) {
                                //mainGUI.setVisible(false);
                                clientController = new ClientController(menuItemHashMap, users.indexOf(user), users);
                                clientController.deliveryService.addObserver(employeeControler);
                            }
                            if (user.role.equals("admin")) {
                                adminController = new AdminController(menuItemHashMap, users);
                                //mainGUI.setVisible(false);
                            }
                            if(user.role.equals("employee")){
                                employeeControler = new EmployeeControler();
                                if(clientController != null){
                                    clientController.deliveryService.addObserver(employeeControler);
                                }
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(mainGUI.logBut, "Incorrect password");
                        }
                    }
                }
                if(!found){
                    JOptionPane.showMessageDialog(mainGUI.logBut, "Incorrect username");
                }
            }
        });

        //ActionListeners for registerGUI

        registerGUI.btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean foundExistentUsername = false;
                boolean incorrectNumber = false;

                mainGUI.setVisible(false);
                String firstname = registerGUI.firstName.getText();
                String lastname = registerGUI.lastName.getText();
                String emailId = registerGUI.email.getText();
                String username = registerGUI.username.getText();
                String mobileNumber = registerGUI.number.getText();
                int len = mobileNumber.length();
                String password = registerGUI.passwordField.getText();
                String r = (String) registerGUI.role.getSelectedItem();

                if (len != 10) {
                    JOptionPane.showMessageDialog(registerGUI.btnNewButton, "Enter a valid mobile number");
                    incorrectNumber = true;
                }
                User newUser = new User(firstname, lastname, username, emailId, password, mobileNumber, r);

                for (User u : users) {
                    if (u.userName.equals(username)) {
                        JOptionPane.showMessageDialog(registerGUI.btnNewButton, "Username already exists");
                        foundExistentUsername = true;
                        break;
                    }
                }
                if (!foundExistentUsername && !incorrectNumber){
                    users.add(newUser);
                    serializator.ser(users);
                    JOptionPane.showMessageDialog(registerGUI.btnNewButton, "Welcome, " + firstname + " " + lastname + " !Your account was created.");
                    registerGUI.setVisible(false);
                    mainGUI.setVisible(true);
                }
            }

        });
    }
    public ArrayList<User> getUsers(){
        return u;
    }

}
