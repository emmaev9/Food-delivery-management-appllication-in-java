package Presentation;

import BLL.DeliveryService;
import BLL.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReportControler {

    public ReportsGUI reportsGUI;
    public DeliveryService deliveryService;
    public ReportControler(ArrayList<User> users){
        this.reportsGUI = new ReportsGUI();
        reportsGUI.setVisible(true);
        reportsGUI.setTitle("REPORTS");
        deliveryService = new DeliveryService(users);

        reportsGUI.generateBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int startHour = Integer.parseInt(reportsGUI.startTimeText.getText());
                int endHour = Integer.parseInt(reportsGUI.endTimeText.getText());

                deliveryService.reportOne(startHour,endHour);
                System.out.println("BUTON APASAT");
            }
        });

        reportsGUI.generateBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int times = Integer.parseInt(reportsGUI.ordersText.getText());
                deliveryService.reportTwo(times);
            }
        });

        reportsGUI.generateBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int minNumber = Integer.parseInt(reportsGUI.minOrdersText.getText());
                int minValue = Integer.parseInt(reportsGUI.minValueText.getText());

                deliveryService.reportThree(minNumber,minValue);
            }
        });

        reportsGUI.generateBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int year = Integer.parseInt(reportsGUI.years.getSelectedItem().toString());
                int mo = Integer.parseInt(reportsGUI.months.getSelectedItem().toString());
                int day = Integer.parseInt(reportsGUI.days.getSelectedItem().toString());

                deliveryService.reportFour(year,mo,day);
            }
        });
    }
}
