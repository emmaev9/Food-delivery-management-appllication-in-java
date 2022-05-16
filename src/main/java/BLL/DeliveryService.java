package BLL;

import DAL.FileSplit;
import java.io.FileWriter;
import DAL.Serializator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements Serializable, iDeliveryServiceProcessing {
    private List<Observer> observers;
    public HashMap<Order, ArrayList<MenuItem>> orders;
    private HashMap<String, MenuItem> menuItemHashMap;
    private Serializator serializator;
    private FileSplit fileSplit;
    private ArrayList<User> users;

    public DeliveryService(ArrayList<User> users){
        observers = new ArrayList<Observer>();
        serializator = new Serializator();
        fileSplit = new FileSplit();
        orders = new HashMap<>();
        this.users = users;
        chooseFile();
        chechIfExists();
    }

    @Override
    public void createOrder(Order order) {
        orders.put(order, order.getProducts());
        serializator.serOrder(orders);
        Bill.createBill(order);

        setChanged();
        System.out.println("s-a notdfasdas");
        notifyObservers(order);
        clearChanged();

    }


    @Override
    public void addProduct(BaseProduct menuItem) {
        menuItemHashMap.put(menuItem.title,menuItem);
        serializator.serCSV(menuItemHashMap);
    }

    @Override
    public void deleteProduct(String key) {
        menuItemHashMap.remove(key);
        serializator.serCSV(menuItemHashMap);
    }

    @Override
    public void modifyProduct(BaseProduct menuItem) {
        menuItemHashMap.get(menuItem.title).setPrice(menuItem.getPrice());
        menuItemHashMap.get(menuItem.title).setSodium(menuItem.getSodium());
        menuItemHashMap.get(menuItem.title).setFat(menuItem.getFat());
        menuItemHashMap.get(menuItem.title).setProtein(menuItem.getProtein());
        menuItemHashMap.get(menuItem.title).setRating(menuItem.getRating());
        menuItemHashMap.get(menuItem.title).setCalories(menuItem.getCalories());
        serializator.serCSV(menuItemHashMap);
    }
     @Override
     public void addCompositeProduct(ArrayList<String> titles, String name, String rating){
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        for(int i = 0;i < titles.size();i++){
            menuItems.add(menuItemHashMap.get(titles.get(i)));
        }
        CompositeProduct newCopositeProduct = new CompositeProduct(menuItems,name,rating);
        for(MenuItem menuItem: menuItems){
            System.out.println(menuItem.getPrice());
        }
        menuItemHashMap.put(newCopositeProduct.getTitle(), newCopositeProduct);
        serializator.serCSV(menuItemHashMap);
     }

     public ArrayList<MenuItem> filterProducts(String title, int minPrice, int maxPrice, int minRating, int maxRating, int minCalories, int maxCalories, int minFat, int maxFat, int minSodium, int maxSodium, int minProtein, int maxProtein){

         List<MenuItem> list = menuItemHashMap.entrySet().stream().filter(
                 entry-> {
                     MenuItem item = entry.getValue();
                     if(item.getPrice() >= minPrice && item.getPrice() <= maxPrice && item.getSodium() >= minSodium && item.getSodium() <=maxSodium &&
                             item.getCalories() >= minCalories && item.getCalories() <= maxCalories && item.getFat() >= minFat && item.getFat() <= maxFat &&
                             item.getProtein() >= minProtein && item.getProtein() <= maxProtein && item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                         return true;
                     }
                     else
                         return false;
                 }
         ).map(c->{return c.getValue();}).collect(Collectors.toList());
         return (ArrayList<MenuItem>) list;
     }



    public void chooseFile(){
        HashMap<String, MenuItem> csvHashMap = fileSplit.splite();
        File f = new File("MenuItems.bin");
        if(!f.exists()){
            menuItemHashMap = csvHashMap;
        }
        else {
            menuItemHashMap = serializator.deserCSV();
        }
    }
    public void reportOne(int startHour, int endHour){
        List<Order> ord = orders.keySet().stream().filter(o -> o.getOrderDate().getHour() >= startHour && o.getOrderDate().getHour() <= endHour).collect(Collectors.toList());
        for(Order o : ord){
            System.out.println(o.getOrderId());
        }
        File f = new File("Report1.txt");
        try {
            FileWriter fileWriter = new FileWriter(f, false);
            for(Order o: ord) {
                fileWriter.write("Report 1: time interval of the orders:["+startHour+","+endHour+"]"+ "\n\n");
                fileWriter.write("OrderID: "+ o.getOrderId()+"\n");
                fileWriter.write("ClientID: "+  o.getClientId()+"\n");
                fileWriter.write("Products: ");
                for(int i = 0; i< o.getProducts().size();i++) {
                    fileWriter.write(o.getProducts().get(i).getTitle() + ", ");
                }
                fileWriter.write("Date: " + o.getOrderDate()+"\n\n");
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void reportTwo(int times){
        HashMap<String, Integer> products = new HashMap<String, Integer>();
        for(MenuItem m: menuItemHashMap.values()){
            products.put(m.getTitle(),0);
            System.out.println(m.getTitle());
        }
        orders.entrySet().stream().forEach(o -> {
            ArrayList<MenuItem> items = o.getValue();
            for(MenuItem m: items){
                int currentCount = products.get(m.getTitle());
                products.put(m.getTitle(),currentCount+1);
            }
        });
        List<String> list = products.entrySet().stream().filter( p -> p.getValue() > times).map(c-> c.getKey()).collect(Collectors.toList());
        File f = new File("Report2.txt");
        try {
            FileWriter fileWriter = new FileWriter(f, false);
            fileWriter.write("Report 2: the products ordered more than "+ times + " times\n\n");
            fileWriter.write("Products: ");
            for(String m: list){
                fileWriter.write(m +"\n");
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void reportThree(int minNumber, int minValue){
        HashMap<Integer, Integer> clientOrderCount = new HashMap<Integer, Integer>();
        for(Order order : orders.keySet()){
            clientOrderCount.put(order.getClientId(), 0);
        }
        orders.keySet().stream().forEach(o -> {
            int sum = 0;
            for(MenuItem i : orders.get(o)){
                sum += i.getPrice();
            }
            if(sum > minValue) {
                clientOrderCount.put(o.getClientId(), clientOrderCount.get(o.getClientId()) + 1);
            }
        });

        List<Integer> clientsIDs = clientOrderCount.entrySet().stream().filter(o-> o.getValue() > minNumber).map(o -> o.getKey()).collect(Collectors.toList());
        File f = new File("Report3.txt");
        try {
            FileWriter fileWriter = new FileWriter(f, false);
            fileWriter.write("Report 3: the clients that have ordered more than "+minNumber+" times so far and the value of the order was higher than "+minValue+"\n\n");
            fileWriter.write("Clients: ");

            System.out.println("Useri" + users.size());


            for(Integer id: clientsIDs){
                System.out.println("idcautat: " + id);
                User u = users.get(id);
                fileWriter.write("Id: "+id+"\n");
                fileWriter.write("Name: " + u.firstName +" "+u.lastName+"\n\n");
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void reportFour(int year, int month, int day){
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(Order order : orders.keySet()){
            for(MenuItem m: order.getProducts()) {
                hashMap.put(m.getTitle(), 0);
            }
        }

        //System.out.println(year + " " + month + " " + day);

        orders.entrySet().stream().filter(o -> o.getKey().getOrderDate().getDayOfMonth() == day && o.getKey().getOrderDate().getMonthValue() == month && o.getKey().getOrderDate().getYear() == year).forEach(o -> {
            ArrayList<MenuItem> items = o.getValue();
            for(MenuItem m: items){
                int currentCount = hashMap.get(m.getTitle());
                hashMap.put(m.getTitle(),currentCount+1);
            }
        });
        File f = new File("Report4.txt");
        try {
            FileWriter fileWriter = new FileWriter(f, false);
            fileWriter.write("Report 4: the products ordered in "+year+"-"+month+"-"+day+ " with the number of times they havebeen ordered.\n\n");
            for(Map.Entry<String,Integer> id: hashMap.entrySet()){
                if(id.getValue() > 0)
                {
                    fileWriter.write("Product: " + id.getKey()+"\n");
                    fileWriter.write("Number: " +id.getValue()+"\n\n");
                }
            }
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public HashMap<String, MenuItem> getMenuItemHashMap() {
        return menuItemHashMap;
    }

    public void chechIfExists(){
        File f = new File("Orders.bin");
        if(f.exists()){
            orders =  serializator.deserOrder();
        }
    }
}
