package BLL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public interface iDeliveryServiceProcessing {

    //client
    public void createOrder(Order order); //implies computing the price

    //admin
    public void addProduct(BaseProduct menuItem);
    public void deleteProduct(String key);
    public void modifyProduct(BaseProduct menuItem);
    public void addCompositeProduct(ArrayList<String> titles, String name, String rating);

}
