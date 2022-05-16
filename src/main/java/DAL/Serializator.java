package DAL;

import BLL.MenuItem;
import BLL.Order;
import BLL.User;
import com.opencsv.CSVWriter;

import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Serializator {

    public void ser(ArrayList<User> users) {
        try {
            FileOutputStream file = new FileOutputStream("login.bin");
            ObjectOutputStream out  = new ObjectOutputStream(file);
            out.writeObject(users);
            out.flush();
            out.close();
            file.close();
        } catch (IOException a) {
            a.getStackTrace();
        }
    }

    public void deser(ArrayList<User> users) {
        try{
            FileInputStream file1 = new FileInputStream("login.bin");
            ObjectInputStream in = new ObjectInputStream(file1);
            users.addAll  ((ArrayList<User>) in.readObject());
            in.close();
            file1.close();

       }catch(ClassNotFoundException | IOException a){
        a.getStackTrace();
       }
    }
    public void serCSV(HashMap<String, MenuItem> hashMap) {
        try {
            FileOutputStream file = new FileOutputStream("MenuItems.bin");
            ObjectOutputStream out  = new ObjectOutputStream(file);
            out.writeObject(hashMap);
            out.flush();
            out.close();
            file.close();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }
    public HashMap<String,MenuItem> deserCSV() {
        try{
            FileInputStream file1 = new FileInputStream("MenuItems.bin");
            ObjectInputStream in = new ObjectInputStream(file1);
            HashMap<String,MenuItem> hashMap = new HashMap<>();
            hashMap = ((HashMap<String, MenuItem>) in.readObject());

            in.close();
            file1.close();
            return hashMap;

        }catch(ClassNotFoundException | IOException a){
            a.printStackTrace();
            return null;
        }
    }

    public void serOrder(HashMap<Order,ArrayList<MenuItem>> orders) {
        try {
            FileOutputStream file = new FileOutputStream("Orders.bin");
            ObjectOutputStream out  = new ObjectOutputStream(file);
            out.writeObject(orders);
            out.flush();
            out.close();
            file.close();
        } catch (IOException a) {
            a.printStackTrace();
        }
    }

    public HashMap<Order, ArrayList<MenuItem>> deserOrder() {
        try{
            FileInputStream file1 = new FileInputStream("Orders.bin");
            ObjectInputStream in = new ObjectInputStream(file1);
            HashMap<Order,ArrayList<MenuItem>> hashMap = ((HashMap<Order, ArrayList<MenuItem>>) in.readObject());
            in.close();
            file1.close();
            return hashMap;

        }catch(ClassNotFoundException | IOException a){
            a.printStackTrace();
            return null;
        }
    }
}
