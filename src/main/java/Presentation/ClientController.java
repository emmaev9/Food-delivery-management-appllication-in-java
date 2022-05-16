package Presentation;

import BLL.DeliveryService;
import BLL.MenuItem;
import BLL.Order;
import BLL.User;
import DAL.Serializator;

import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class ClientController {
    ClientGUI clientGUI;
    public DeliveryService deliveryService;
    Order order;

    public ClientController(HashMap<String, MenuItem> menuItemHashMap, int user,ArrayList<User> users){

        clientGUI = new ClientGUI(menuItemHashMap);
        deliveryService = new DeliveryService(users);
        clientGUI.addToCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = clientGUI.table.getSelectedRow();
                System.out.println(i);
                TableModel model = clientGUI.table.getModel();
                String name = model.getValueAt(i, 0).toString();
                clientGUI.defaultListModel.add(clientGUI.index,name);
                clientGUI.index++;
            }
        });

        clientGUI.clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientGUI.defaultListModel.clear();
                clientGUI.index = 0;
            }
        });

        clientGUI.deleteFromCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = clientGUI.cart.getSelectedIndex();
                if(selectedIndex!=-1){
                    clientGUI.defaultListModel.remove(selectedIndex);
                }
            }
        });

        clientGUI.orderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> products = new ArrayList<>();
                ArrayList<MenuItem> menuItems = new ArrayList<>();
                int newOrderId = 0;
                for(int i=0;i<clientGUI.defaultListModel.size();i++) {
                    products.add(clientGUI.defaultListModel.get(i).toString());
                }
                for(String s: products){
                    menuItems.add(menuItemHashMap.get(s));
                }
                if(deliveryService.orders.isEmpty()){
                    newOrderId = 1;
                }
                else
                    newOrderId = deliveryService.orders.size() + 1;

                Order order = new Order(newOrderId,user, LocalDateTime.now(), menuItems);
                System.out.println(order.getOrderId() + "  " + order.getClientId() + "  " + order.getOrderDateToString()+"  "+ order.getProducts());
                deliveryService.createOrder(order);

            }
        });

        clientGUI.SearchBtn.addActionListener(new ActionListener() {

            String title;
            int minRating, maxRating, minCalorie, maxCalorie, minProtein, maxProtein, minFat, maxFat, minSodium, maxSodium, minPrice, maxPrice;
            public void actionPerformed(ActionEvent e) {
                if(clientGUI.title.getText().equals(""))     title = "";        else  title = clientGUI.title.getText();
                if(clientGUI.minSodium.getText().equals("")) minSodium = 0;     else  minSodium = Integer.parseInt(clientGUI.minSodium.getText());
                if(clientGUI.maxSodium.getText().equals("")) maxSodium = 10000; else  maxSodium = Integer.parseInt(clientGUI.maxSodium.getText());
                if(clientGUI.minCalorie.getText().equals(""))minCalorie = 0;    else  maxCalorie = Integer.parseInt(clientGUI.minCalorie.getText());
                if(clientGUI.maxCalorie.getText().equals(""))maxCalorie = 10000;else  maxCalorie = Integer.parseInt(clientGUI.maxCalorie.getText());
                if(clientGUI.minProtein.getText().equals(""))minProtein = 0;    else  maxProtein = Integer.parseInt(clientGUI.minProtein.getText());
                if(clientGUI.maxProtein.getText().equals(""))maxProtein = 10000;else  maxProtein = Integer.parseInt(clientGUI.maxProtein.getText());
                if(clientGUI.minPrice.getText().equals(""))  minPrice = 0;      else  minPrice = Integer.parseInt(clientGUI.minPrice.getText());
                if(clientGUI.maxPrice.getText().equals(""))  maxPrice = 10000;  else  maxPrice = Integer.parseInt(clientGUI.maxPrice.getText());
                if(clientGUI.minFat.getText().equals(""))    minFat = 0;        else  minFat = Integer.parseInt(clientGUI.minFat.getText());
                if(clientGUI.maxFat.getText().equals(""))    maxFat = 10000;    else  maxFat = Integer.parseInt(clientGUI.maxFat.getText());

                ArrayList<MenuItem> items = deliveryService.filterProducts(title,minPrice,maxPrice,minRating, maxRating,minCalorie, maxCalorie,minFat,maxFat,minSodium,maxSodium, minProtein,maxProtein);
                refreshTableAfterFilter(items);
            }
        });
    }
    public void refreshTableAfterFilter(ArrayList<MenuItem> itemArrayList) {
        HashMap<String, MenuItem> hashMap = new HashMap<>();
        for(MenuItem menuItem: itemArrayList){
            hashMap.put(menuItem.getTitle(), menuItem);
        }
        clientGUI.tableModel.setRowCount(0);
        clientGUI.tableModel.setColumnCount(0);
        Properties properties = new Properties();
        clientGUI.tableModel = properties.retrieveProperties(hashMap,clientGUI.tableModel);
    }
}
