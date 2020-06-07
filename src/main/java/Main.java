import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.EventListener;
import test.FoodType;
import test.Zoo;
import test.configuration.AnnotationConfiguration;
import test.dto.Food;
import test.event.ZooEvent;
import test.service.ZooService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
//        Zoo zoo = new Zoo(new Dog(), new Cat());
//        zoo.getCat().voice();
//        zoo.getDog().voice();
//    }

    public static List<Food> food = new ArrayList<>();
    public static int currentFood = 0;

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        feedAnimal(context);
    }

    public static void feedAnimal(ApplicationContext context) {
        ZooService service = context.getBean(ZooService.class);
        Food food = new Food(LocalDateTime.now().plusHours(6), FoodType.MEAT);
        service.feed(food);
    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
