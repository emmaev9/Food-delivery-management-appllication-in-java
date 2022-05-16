package BLL;

import java.io.SequenceInputStream;
import java.io.Serializable;

public abstract class MenuItem implements Serializable {

    protected String title;
    protected double rating;
    protected int price,fat, calories, sodium, protein;

    public String getTitle() {
        return title;
    }

    public double getRating(){return rating;}
    public abstract int getPrice();
    public abstract int getFat();
    public abstract int getSodium();
    public abstract int getCalories();
    public abstract int getProtein();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }
}
