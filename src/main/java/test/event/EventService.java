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

    @Autowired
    public EventService(ZooService zooService) {
        this.zooService = zooService;
        this.food = new ArrayList<>();
    }

    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        System.out.println(zooEvent.getMessage());
    }
}
