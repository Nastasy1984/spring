package test.dto;

import test.FoodType;

import java.time.LocalDateTime;

public class Food {
    //private String foodName;
    private LocalDateTime expirationDate;
    private FoodType foodType;

    public Food (LocalDateTime expirationDate, FoodType foodType){
        this.foodType = foodType;
        this.expirationDate = expirationDate;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    /*public String getFoodName() {
        return foodName;
    }*/

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /*public void setFoodName(String foodName) {
        this.foodName = foodName;
    }*/

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
