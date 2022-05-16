package BLL;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {
    private int orderId;
    private int clientId;
    //private final LocalDateTime FORMATTER = LocalDateTime.ofPattern("MM/dd/yyyy 'at' hh:mm a");
    private LocalDateTime localDateTime;
    private ArrayList<MenuItem> products;

    public Order(int orderId, int clientId, LocalDateTime orderDate, ArrayList<MenuItem> products){
        this.orderId = orderId;
        this.clientId = clientId;
        this.localDateTime = LocalDateTime.now();
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public ArrayList<MenuItem> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<MenuItem> products) {
        this.products = products;
    }

    public LocalDateTime getOrderDate() {
        return localDateTime;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.localDateTime = orderDate;
    }

    public String getOrderDateToString(){
        int year, month, day, hour,min,sec;
        year = localDateTime.getYear();
        month = localDateTime.getMonthValue();
        day = localDateTime.getDayOfMonth();
        hour = localDateTime.getHour();
        min = localDateTime.getMinute();
        sec = localDateTime.getSecond();
        String s = year + "/"+month+"/"+day+ " at " + hour+":"+min+":"+sec;
        return s;
    }

    public int hashCode(){
        return (int)localDateTime.hashCode() + orderId + clientId;
    }


}
