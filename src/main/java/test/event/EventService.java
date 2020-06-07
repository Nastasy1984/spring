package test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import test.FoodType;
import test.Zoo;
import test.dto.Food;
import test.service.ZooService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    private ZooService zooService;
    private List<Food> food;
    private static int count = 0;

    @Autowired
    public EventService(ZooService zooService) {
        this.zooService = zooService;
        this.food = new ArrayList<>();

        food.add(new Food(LocalDateTime.now().plusHours(7), FoodType.MILK));
        food.add(new Food(LocalDateTime.now().plusHours(7), FoodType.FISH));
        food.add(new Food(LocalDateTime.now().plusHours(7), FoodType.FISH_FEED));
        food.add(new Food(LocalDateTime.now().plusHours(7), FoodType.CORN));
    }

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        System.out.println(zooEvent.getMessage());
        System.out.println();
        if (count < food.size()) {
            count++;
            zooService.feed(food.get(count - 1));
        }
    }
}
