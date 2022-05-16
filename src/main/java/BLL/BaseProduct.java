package BLL;

import java.io.Serializable;

public class BaseProduct extends  MenuItem{

    public BaseProduct(){}
    public BaseProduct(String title, double rating, int calories, int protein, int fat, int sodium, int price){
        this.title = title;
        this.calories = calories;
        this.rating = rating;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }


    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getFat() {
        return fat;
    }

    @Override
    public int getSodium() {
        return sodium;
    }

    @Override
    public int getCalories() {
        return calories;
    }

    @Override
    public int getProtein() {
        return protein;
    }



}
