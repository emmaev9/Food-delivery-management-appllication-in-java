package Presentation;

import BLL.MenuItem;

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

public class ClientGUI extends JFrame {
    public JTable menu;
    public DefaultTableModel menuModel;
    public JButton orderBtn, addToCartBtn, SearchBtn, clearBtn, deleteFromCartBtn;
    public JList cart;
    public DefaultListModel defaultListModel;
    public ArrayList<String> cartProducts;
    public int index = 0;

    public JFrame frame;
    public JPanel panel1, panel2, panel3,panel4,panel5,panel6, panel7, panel8;
    public JLabel serach, labelMinCalorie,labelMaxCalorie,labelMinRating,labelMaxRating, labelMinPrice, labelMaxPrice, labelMinFat, labelMaxFat, labelTitle,labelMinSodium, labelMaxSodium, labelMinProtein, labelMaxProtein;
    public JTextField title,minPrice, maxPrice, minCalorie, maxCalorie, minRating, maxRating, minFat, maxFat, minSodium, maxSodium, minProtein, maxProtein;
    public JTable table;
    public DefaultTableModel tableModel;
    private Properties properties;
    public HashMap<String, MenuItem> menuItemHashMap;
    public ClientGUI(HashMap<String,MenuItem> menuItemHashMap){
            this.cartProducts = new ArrayList<>();
            defaultListModel = new DefaultListModel();
            this.menuItemHashMap = menuItemHashMap;
            this.panel1 = new JPanel();
            this.panel2 = new JPanel();
            this.panel3 = new JPanel();
            this.panel4 = new JPanel();
            this.panel5 = new JPanel();
            this.panel6 = new JPanel();
            this.panel7 = new JPanel();
            this.panel8 = new JPanel();
            properties = new Properties();
            frame = new JFrame("CLIENT");
            frame.setVisible(true);
            frame.setSize(1100, 500);

            panel1 = new JPanel();
            panel1.setBorder(new EmptyBorder(new Insets(30, 200, 150, 200)));

            serach = new JLabel();
            serach.setText("SEARCH FOR PRODUCTS");
            panel1.add(serach);

            labelTitle = new JLabel("Title");
            panel1.add(labelTitle);
            title = new JTextField(15);
            panel1.add(title);

            labelMinPrice = new JLabel("Min Price");
            panel3.add(labelMinPrice);
            minPrice = new JTextField(10);
            panel3.add(minPrice);
            labelMaxPrice = new JLabel("Max Price");
            panel3.add(labelMaxPrice);
            maxPrice = new JTextField(10);
            panel3.add(maxPrice);

            labelMinRating = new JLabel("Min Rating");
            panel4.add(labelMinRating);
            minRating = new JTextField(10);
            panel4.add(minRating);
            labelMaxRating = new JLabel("Max Rating");
            panel4.add(labelMaxRating);
            maxRating = new JTextField(10);
            panel4.add(maxRating);

           labelMinCalorie = new JLabel("Min Calorie");
           panel5.add(labelMinCalorie);
           minCalorie = new JTextField(10);
           panel5.add(minCalorie);
           labelMaxCalorie = new JLabel("Max Calorie");
           panel5.add(labelMaxCalorie);
           maxCalorie = new JTextField(10);
           panel5.add(maxCalorie);

           labelMinProtein = new JLabel("Min Protein");
           panel6.add(labelMinProtein);
           minProtein = new JTextField(10);
           panel6.add(minProtein);
           labelMaxProtein = new JLabel("Max Protein");
           panel6.add(labelMaxProtein);
           maxProtein = new JTextField(10);
           panel6.add(maxProtein);


           labelMinFat = new JLabel("Min Fat");
           panel7.add(labelMinFat);
           minFat = new JTextField(10);
           panel7.add(minFat);
           labelMinFat = new JLabel("Max Fat");
           panel7.add(labelMinFat);
           maxFat = new JTextField(10);
           panel7.add(maxFat);

          labelMinSodium = new JLabel("Min Sodium");
          panel8.add(labelMinSodium);
          minSodium = new JTextField(10);
          panel8.add(minSodium);
          labelMinSodium = new JLabel("Max Sodium");
          panel8.add(labelMinSodium);
          maxSodium = new JTextField(10);
          panel8.add(maxSodium);

          SearchBtn = new JButton("Search");
          SearchBtn.setBackground(Color.red);
          SearchBtn.setForeground(Color.white);
          serach.setForeground(Color.red);
          serach.setFont(new Font("Times New Roman", Font.BOLD, 15));

             panel1.add(panel3);
             panel1.add(panel4);
             panel1.add(panel5);
             panel1.add(panel6);
             panel1.add(panel7);
             panel1.add(panel8);
             panel1.add(SearchBtn);
            panel2.setBorder(new EmptyBorder(new Insets(75, 200, 150, 200)));

            addToCartBtn = new JButton("Add to cart");
            addToCartBtn.setForeground(Color.white);
            addToCartBtn.setBackground(Color.red);
            panel2.add(addToCartBtn);

           cart = new JList(defaultListModel);
           panel2.add(cart);

           orderBtn = new JButton("Make Order");
           orderBtn.setBackground(Color.red);
           orderBtn.setForeground(Color.white);
           panel2.add(orderBtn);

           deleteFromCartBtn = new JButton("Delete from cart");
           deleteFromCartBtn.setBackground(Color.red);
           deleteFromCartBtn.setForeground(Color.white);
           //panel2.add(deleteFromCartBtn);

           clearBtn = new JButton("Clear cart");
           clearBtn.setForeground(Color.white);
           clearBtn.setBackground(Color.red);
           panel2.add(clearBtn);


            tableModel = new DefaultTableModel();
            tableModel = properties.retrieveProperties(menuItemHashMap, tableModel);

            table = new JTable(tableModel);
            table.setBounds(30, 40, 400, 100);
            table.setBackground(new Color(255, 230, 255));
            JScrollPane sp = new JScrollPane(table);

            table.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int i = table.getSelectedRow();
                    System.out.println(i);
                    TableModel model = table.getModel();
                    String name = model.getValueAt(i, 0).toString();
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
            panel3.setBackground(new Color(255, 230, 255));
            panel4.setBackground(new Color(255, 230, 255));
            panel5.setBackground(new Color(255, 230, 255));
            panel6.setBackground(new Color(255, 230, 255));
            panel7.setBackground(new Color(255, 230, 255));
            panel8.setBackground(new Color(255, 230, 255));

            frame.add(panel2);
            frame.add(panel1);
            frame.add(sp);
            frame.setLayout(new GridLayout());
        }


}

