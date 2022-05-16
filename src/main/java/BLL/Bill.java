package BLL;

import DAL.Serializator;
import Presentation.ClientController;
import Presentation.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Bill{

    public static void createBill(Order order){
        Serializator serializator = new Serializator();

        ArrayList<User> users = new ArrayList<>();
        serializator.deser(users);
        User user = users.get(order.getClientId());

        ArrayList<MenuItem> baseProduct = new ArrayList<>();
        baseProduct = order.getProducts();

        String numeFisier = "Bill" + order.getOrderId() + ".txt";
        int totalPrice = 0;
        File file = new File(numeFisier);

        try{
            FileWriter billWriter = new FileWriter(file, false);

            billWriter.write("Bill\n\n");
            billWriter.write("First Name: " + user.firstName+"\n");
            billWriter.write("Last Name: " + user.lastName+"\n");
            billWriter.write("Email: " + user.email + "\n");
            billWriter.write("Phone number: " + user.phoneNumber + "\n\n");
            billWriter.write("Products: "+"\n");
            for(MenuItem b: baseProduct) {
                billWriter.write(b.getTitle() + "   Price: " + b.getPrice() + "\n");
                totalPrice = totalPrice + b.getPrice();
            }
            billWriter.write("Total price: "+ totalPrice +"\n");
            billWriter.write("Date: " + order.getOrderDateToString());
            billWriter.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }

}

