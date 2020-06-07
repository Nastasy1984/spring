package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import test.Animal;
import test.Zoo;
import test.dto.Food;
import test.event.ZooEvent;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService {
    private final Zoo zoo;
    private ApplicationContext context;

    @Autowired
    public ZooServiceImpl(Zoo zoo, ApplicationContext context) {
        this.zoo = zoo;
        this.context = context;
    }

    @Override
    public void feed(Food food) {
        List<Animal> angryAnimals = zoo.getAnimals()
                .stream()
                .peek(animal -> animal.eat(food))
                .filter(Animal::isAngry)
                .collect(Collectors.toList());
        System.out.println("Still angry: " + angryAnimals);
        if (!angryAnimals.isEmpty()){
            context.publishEvent(new ZooEvent(zoo, "There are still angry animals"));
        }
    }
}
