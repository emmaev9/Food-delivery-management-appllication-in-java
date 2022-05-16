package Presentation;

import BLL.BaseProduct;
import BLL.MenuItem;
import BLL.User;

import javax.swing.table.DefaultTableModel;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Properties {

    public Properties() {}

    public DefaultTableModel retrieveProperties(HashMap<String,MenuItem> products, DefaultTableModel tableModel) {

        tableModel.addColumn("Title");
        tableModel.addColumn("Rating");
        tableModel.addColumn("Calories");
        tableModel.addColumn("Protein");
        tableModel.addColumn("Fat");
        tableModel.addColumn("Sodium");
        tableModel.addColumn("Price");

        String[][] data = new String[products.size()][7];
        int i = 0;
        for (MenuItem p: products.values()) {
                data[i][0] = p.getTitle().toString();
                data[i][1] = String.valueOf(p.getRating());
                data[i][2] = String.valueOf(p.getCalories());
                data[i][3] = String.valueOf(p.getProtein());
                data[i][4] = String.valueOf(p.getFat());
                data[i][5] = String.valueOf(p.getSodium());
                data[i][6] = String.valueOf(p.getPrice());
                tableModel.addRow(data[i]);
                i++;
        }

        return tableModel;
    }
}
