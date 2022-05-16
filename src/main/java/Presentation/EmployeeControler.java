package Presentation;

import BLL.DeliveryService;
import BLL.MenuItem;
import BLL.Order;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EmployeeControler implements Observer {

    EmployeeGUI gui;

    public EmployeeControler(){
        gui = new EmployeeGUI();
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("EMPLOYEE");
        mainFrame.setContentPane(gui.EmployeePanel);
        mainFrame.setPreferredSize(new Dimension(300, 300 ));
        mainFrame.setSize(500,300);
        gui.EmployeePanel.setBackground(new Color(255, 230, 255));
        mainFrame.setVisible(true);

    }

    @Override
    public void update(Observable o , Object arg ) {
        System.out.println("Notified");
        if(arg instanceof Order){
            gui.newOrderLabel.setText("New order added");

            Order order = (Order)arg;
            gui.orderIDField.setText(String.valueOf(order.getOrderId()));
            gui.clientIDField.setText(String.valueOf(order.getClientId()));
            gui.orderedItemsListModel.removeAllElements();
            for(MenuItem m : order.getProducts()){
                gui.orderedItemsListModel.addElement(m.getTitle());
            }

        }
    }
}
