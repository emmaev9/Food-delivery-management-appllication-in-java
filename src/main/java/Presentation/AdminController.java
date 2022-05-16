package Presentation;

import BLL.BaseProduct;
import BLL.DeliveryService;
import BLL.MenuItem;
import BLL.User;
import DAL.FileSplit;
import DAL.Serializator;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminController {
    AdminGUI adminGUI;
    Serializator serializator;
    DeliveryService deliveryService;
    ArrayList<String> listOfSelectedProducts = new ArrayList<>();

    public AdminController(HashMap<String, MenuItem> menuItemHashMap, ArrayList<User> users) {
        adminGUI = new AdminGUI(menuItemHashMap);
        deliveryService = new DeliveryService(users);
        serializator = new Serializator();

        adminGUI.modifyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productTitle = adminGUI.textTitle.getText();
                String productRating = adminGUI.textRating.getText();
                String productCalorie = adminGUI.textCalories.getText();
                String productProtein = adminGUI.textProtein.getText();
                String productFat = adminGUI.textFat.getText();
                String productSodium = adminGUI.textSodium.getText();
                String productPrice = adminGUI.textPrice.getText();

                BaseProduct newProduct = new BaseProduct(productTitle,Double.parseDouble(productRating),Integer.parseInt(productCalorie)
                        ,Integer.parseInt(productProtein),Integer.parseInt(productFat),Integer.parseInt(productSodium),
                        Integer.parseInt(productPrice));

                deliveryService.modifyProduct(newProduct);
                refreshTable();
            }
        });

        adminGUI.deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productTitle = adminGUI.textTitle.getText();
                deliveryService.deleteProduct(productTitle);
                refreshTable();
            }
        });

        adminGUI.addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productTitle = adminGUI.textTitle.getText();
                String productRating = adminGUI.textRating.getText();
                String productCalorie = adminGUI.textCalories.getText();
                String productProtein = adminGUI.textProtein.getText();
                String productFat = adminGUI.textFat.getText();
                String productSodium = adminGUI.textSodium.getText();
                String productPrice = adminGUI.textPrice.getText();

                BaseProduct newProduct = new BaseProduct(productTitle,Double.parseDouble(productRating),Integer.parseInt(productCalorie)
                                                         ,Integer.parseInt(productProtein),Integer.parseInt(productFat),Integer.parseInt(productSodium),
                                                          Integer.parseInt(productPrice));
                deliveryService.addProduct(newProduct);
                refreshTable();
            }
        });
        adminGUI.newCompositeProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   String newProductName = adminGUI.textCompName.getText();
                   String newProductRating = adminGUI.textCompRating.getText();
                   deliveryService.addCompositeProduct(listOfSelectedProducts, newProductName, newProductRating);
                   listOfSelectedProducts.clear();
                   refreshTable();

            }
        });

        adminGUI.plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i  = adminGUI.table.getSelectedRow();
                TableModel model = adminGUI.table.getModel();
                listOfSelectedProducts.add(model.getValueAt(i, 0).toString());
            }
        });

        adminGUI.reportBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportControler reportControler = new ReportControler(users);

            }
        });


    }

    public void refreshTable() {
        HashMap<String, MenuItem> hashMap = new HashMap<>();
        adminGUI.tableModel.setRowCount(0);
        adminGUI.tableModel.setColumnCount(0);
        hashMap = deliveryService.getMenuItemHashMap();
        Properties properties = new Properties();
        adminGUI.tableModel = properties.retrieveProperties(hashMap,adminGUI.tableModel);
    }





}
