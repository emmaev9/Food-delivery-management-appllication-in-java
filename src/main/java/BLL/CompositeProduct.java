package BLL;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class CompositeProduct extends  MenuItem{
    private List<MenuItem> menuItems;

    public CompositeProduct(){}

    public CompositeProduct(List<MenuItem> menuItems, String title, String rating){
        this.title = title;
        this.rating = Double.parseDouble(rating);
        this.menuItems = menuItems;
    }


    public int getPrice() {
        int allPrice = 0;
        for (MenuItem product : menuItems) {
            allPrice = allPrice + product.getPrice();
        }
        return allPrice;
    }

    @Override
    public int getFat() {
        int allFat = 0;
        for (MenuItem product : menuItems) {
            allFat = allFat + product.getFat();
        }
        return allFat;
    }

    @Override
    public int getSodium() {
        int allSodium = 0;
        for(MenuItem product: menuItems){
            allSodium = allSodium + product.getSodium();
        }
        return allSodium;
    }

    @Override
    public int getCalories() {
        int allCalories = 0;
        for(MenuItem product: menuItems){
            allCalories = allCalories + product.getCalories();
        }
        return allCalories;
    }

    @Override
    public int getProtein() {
        int allProtein = 0;
        for(MenuItem product: menuItems){
            allProtein = allProtein + product.getProtein();
        }
        return allProtein;
    }


}
