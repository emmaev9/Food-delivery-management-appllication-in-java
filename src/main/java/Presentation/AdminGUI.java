package Presentation;

import BLL.BaseProduct;
import BLL.CompositeProduct;
import BLL.MenuItem;
import DAL.FileSplit;
import DAL.Serializator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdminGUI extends JFrame {
    public JTable menu;
    public DefaultTableModel menuModel;
    public JButton importBtn, addBtn, deleteBtn, modifyBtn, newCompositeProductBtn, reportBtn, logOutBtn, plus;
    public JPanel contentPane;
    public JPanel tablePanel;
    public JPanel mainPanel;
    public JFrame frame;
    public JPanel panel1, panel2, panel3;
    public JLabel lableTitle, lableRating, lablePrice, lableFat, lableProtein, lableSodium, lableCalories, lableCompName, lableCompRating;
    public JTextField textTitle, textCalories, textRating, textFat, textSodium, textProtein, textPrice, textCompName, textCompRating;
    public JTable table;
    public DefaultTableModel tableModel;
    private Properties properties;
    public HashMap<String, MenuItem> menuItemHashMap;
    public AdminGUI(HashMap<String, MenuItem> menuItemHashMap) {
        this.menuItemHashMap = menuItemHashMap;
        properties = new Properties();
        frame = new JFrame("ADMINISTRATOR");
        frame.setVisible(true);
        frame.setSize(1100, 500);

        panel1 = new JPanel();
        panel1.setBorder(new EmptyBorder(new Insets(30, 200, 150, 200)));


        lableTitle = new JLabel("Title");
        panel1.add(lableTitle);
        textTitle = new JTextField(10);
        panel1.add(textTitle);

        lableRating = new JLabel("Rating");
        panel1.add(lableRating);
        textRating = new JTextField(10);
        panel1.add(textRating);

        lableCalories = new JLabel("Calories");
        panel1.add(lableCalories);
        textCalories = new JTextField(10);
        panel1.add(textCalories);

        lableProtein = new JLabel("Protein");
        panel1.add(lableProtein);
        textProtein = new JTextField(10);
        panel1.add(textProtein);

        lableFat = new JLabel("Fat");
        panel1.add(lableFat);
        textFat = new JTextField(10);
        panel1.add(textFat);

        lableSodium = new JLabel("Sodium");
        panel1.add(lableSodium);
        textSodium = new JTextField(10);
        panel1.add(textSodium);

        lablePrice = new JLabel("Price");
        panel1.add(lablePrice);
        textPrice = new JTextField(10);
        panel1.add(textPrice);

        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        // panel2.setBorder(new EmptyBorder(new Insets(30, 200, 150, 200)));

        addBtn = new JButton("Add base product");
        addBtn.setBackground(Color.red);
        addBtn.setForeground(Color.white);
        panel2.add(addBtn);


        deleteBtn = new JButton("Delete product");
        deleteBtn.setBackground(Color.red);
        deleteBtn.setForeground(Color.white);
        panel2.add(deleteBtn);

        modifyBtn = new JButton("Modify product");
        modifyBtn.setBackground(Color.red);
        modifyBtn.setForeground(Color.white);
        panel2.add(modifyBtn);


        reportBtn = new JButton("Generate reports");
        reportBtn.setBackground(Color.red);
        reportBtn.setForeground(Color.white);
        panel2.add(reportBtn);

        newCompositeProductBtn = new JButton("New composite product");
        newCompositeProductBtn.setBackground(Color.red);
        newCompositeProductBtn.setForeground(Color.white);
        panel2.add(newCompositeProductBtn);

        plus = new JButton(" + ");
        plus.setBackground(Color.red);
        plus.setForeground(Color.white);
        panel2.add(plus);



        lableCompName = new JLabel("Composite product name");
        panel2.add(lableCompName);

        textCompName = new JTextField(10);
        panel2.add(textCompName);

        lableCompRating = new JLabel("Composite product rating");
        panel2.add(lableCompRating);

        textCompRating = new JTextField(10);
        panel2.add(textCompRating);


        panel2.setBorder(new EmptyBorder(new Insets(75, 200, 150, 200)));

       /* logOutBtn = new JButton("Log out");
        logOutBtn.setBackground(Color.red);
        panel2.add(logOutBtn);
        */
        tableModel = new DefaultTableModel();
        tableModel = properties.retrieveProperties(menuItemHashMap, tableModel);

        table = new JTable(tableModel);
        table.setBounds(30, 40, 400, 100);
        table.setBackground(new Color(255, 230, 255,250));
        JScrollPane sp = new JScrollPane(table);

        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = table.getSelectedRow();
                System.out.println(i);
                TableModel model = table.getModel();
                textTitle.setText(model.getValueAt(i, 0).toString());
                textRating.setText(model.getValueAt(i, 1).toString());
                textCalories.setText(model.getValueAt(i, 2).toString());
                textProtein.setText(model.getValueAt(i,3).toString());
                textFat.setText(model.getValueAt(i,4).toString());
                textSodium.setText(model.getValueAt(i,5).toString());
                textPrice.setText(model.getValueAt(i,6).toString());
            }


            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        panel1.setBackground(new Color(255, 230, 255));
        panel2.setBackground(new Color(255, 230, 255));
        frame.add(panel2);
        frame.add(panel1);
        frame.add(sp);
        frame.setLayout(new GridLayout());
    }
    public void refreshTable() {
        HashMap<String, MenuItem> hashMap = new HashMap<>();
        tableModel.setRowCount(0);
        tableModel.setColumnCount(0);
        hashMap = menuItemHashMap;
        Properties properties = new Properties();
        tableModel = properties.retrieveProperties(hashMap,tableModel);
    }


}
