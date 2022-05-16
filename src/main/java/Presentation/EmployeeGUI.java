package Presentation;

import javax.swing.*;
import java.awt.*;

public class EmployeeGUI {
    public JLabel newOrderLabel;
    public JTextField orderIDField;
    public JTextField clientIDField;
    private JLabel products;
    public JList orderedItemsList;
    public DefaultListModel<String> orderedItemsListModel;
    public JPanel EmployeePanel;

    private void createUIComponents() {
        orderedItemsListModel = new DefaultListModel<String>();
        orderedItemsList = new JList(orderedItemsListModel);

    }
}
