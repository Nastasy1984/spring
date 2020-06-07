package test;

import org.springframework.stereotype.Component;
import test.dto.Food;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cat implements Animal {
    private boolean angry = true;

    public void voice() {
        System.out.println("mi");
    }

    @Override
    public boolean eat(Food food) {
        angry = false;
        return isAngry();
    }

    @Override
    public boolean isAngry() {
        return angry;
    }

    @Override
    public List<FoodType> getPossibleFeedTypes() {
        List<FoodType> foodTypeList = new ArrayList<>();
        foodTypeList.add(FoodType.MEAT);
        foodTypeList.add(FoodType.MILK);
        foodTypeList.add(FoodType.FISH);
        return foodTypeList;
    }
}
