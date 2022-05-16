package Presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class ReportsGUI extends JFrame {
     public JPanel contentPane;
     public JComboBox<String> years,days,months;
     public JTextField firstName, lastName, username, email, number;
     public JButton generateBtn1, generateBtn2, generateBtn3, generateBtn4;
     public JTextField startTimeText, endTimeText, ordersText, minOrdersText, minValueText;
     public ReportsGUI(){

          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(450, 190, 350, 400);
          setResizable(false);
          contentPane = new JPanel();
          contentPane.setBackground(new Color(255, 230, 255));
          contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
          setContentPane(contentPane);
          contentPane.setLayout(null);

          JLabel lblNewUserRegister = new JLabel("Reports");
          lblNewUserRegister.setForeground(Color.red);
          lblNewUserRegister.setFont(new Font("Times New Roman", Font.BOLD, 18));
          lblNewUserRegister.setBounds(140, 10, 325, 30);
          contentPane.add(lblNewUserRegister);

          JLabel lbl1 = new JLabel("Start hour");
          lbl1.setFont(new Font("Tahoma", Font.PLAIN, 13));
          lbl1.setBounds(20,50, 60, 20);
          contentPane.add(lbl1);

          startTimeText = new JTextField();
          startTimeText.setFont(new Font("Tahoma", Font.PLAIN, 10));
          startTimeText.setBounds(80, 50, 60, 20);
          contentPane.add(startTimeText);
          startTimeText.setColumns(5);

          JLabel lbl2 = new JLabel("End hour");
          lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
          lbl2.setBounds(170, 50, 80, 20);
          contentPane.add(lbl2);

          endTimeText = new JTextField(7);
          endTimeText.setFont(new Font("Tahoma", Font.PLAIN, 10));
          endTimeText.setBounds(230, 50, 60, 20);
          contentPane.add(endTimeText);
          endTimeText.setColumns(5);

          generateBtn1  = new JButton("Generate report");
          generateBtn1.setFont(new Font("Tahoma", Font.BOLD, 13));
          generateBtn1.setBounds(60, 75, 200, 17);
          generateBtn1.setBackground(Color.red);
          generateBtn1.setForeground(new Color(250,250,250));
          contentPane.add(generateBtn1);

          JLabel l2 = new JLabel("Products ordered more than ");
          l2.setFont(new Font("Tahoma", Font.PLAIN, 13));
          l2.setBounds(20, 130,250, 20);
          contentPane.add(l2);

          ordersText = new JTextField(7);
          ordersText.setFont(new Font("Tahoma", Font.PLAIN, 10));
          ordersText.setBounds(180, 130, 50, 20);
          contentPane.add(ordersText);
          ordersText.setColumns(5);

          JLabel l3 = new JLabel(" times");
          l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
          l3.setBounds(235, 130,60, 20);
          contentPane.add(l3);

          generateBtn2  = new JButton("Generate report");
          generateBtn2.setFont(new Font("Tahoma", Font.BOLD, 13));
          generateBtn2.setBounds(60, 155, 200, 17);
          generateBtn2.setBackground(Color.red);
          generateBtn2.setForeground(new Color(250,250,250));
          contentPane.add(generateBtn2);


          JLabel l4 = new JLabel("Min number of orders");
          l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
          l4.setBounds(20, 190,250, 20);
          contentPane.add(l4);

          minOrdersText = new JTextField(7);
          minOrdersText.setFont(new Font("Tahoma", Font.PLAIN, 10));
          minOrdersText.setBounds(180, 190, 50, 20);
          contentPane.add(minOrdersText);
          minOrdersText.setColumns(5);

          JLabel l5 = new JLabel("Min value of order");
          l5.setFont(new Font("Tahoma", Font.PLAIN, 13));
          l5.setBounds(20, 210,250, 20);
          contentPane.add(l5);

          minValueText = new JTextField(7);
          minValueText.setFont(new Font("Tahoma", Font.PLAIN, 10));
          minValueText.setBounds(180, 210, 50, 20);
          contentPane.add(minValueText);
          minValueText.setColumns(5);

          generateBtn3  = new JButton("Generate report");
          generateBtn3.setFont(new Font("Tahoma", Font.BOLD, 13));
          generateBtn3.setBounds(60, 235, 200, 17);
          generateBtn3.setBackground(Color.red);
          generateBtn3.setForeground(new Color(250,250,250));
          contentPane.add(generateBtn3);

          JLabel l6 = new JLabel("Date of order: ");
          l6.setFont(new Font("Tahoma", Font.PLAIN, 13));
          l6.setBounds(20, 280,200, 20);
          contentPane.add(l6);

          String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12",
                          "13","14","15","16","17","18","19","20","21","22",
                          "23","24","25","26","27","28","29","30","31"};
          String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
          String[] year = {"2018","2019","2020","2021","2022"};
          years = new JComboBox<>(year);
          years.setBounds(120,280,60,20);
          contentPane.add(years);

          months = new JComboBox<>(month);
          months.setMaximumRowCount(13);
          months.setBounds(200,280,50,20);
          contentPane.add(months);

          days = new JComboBox<>(day);
          days.setBounds(280,280,50,20);
          contentPane.add(days);

          generateBtn4  = new JButton("Generate report");
          generateBtn4.setFont(new Font("Tahoma", Font.BOLD, 13));
          generateBtn4.setBounds(60, 305, 200, 17);
          generateBtn4.setBackground(Color.red);
          generateBtn4.setForeground(new Color(250,250,250));
          contentPane.add(generateBtn4);
     }
}
