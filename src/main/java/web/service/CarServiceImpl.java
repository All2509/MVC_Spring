package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    public CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car(1, "Kia", "Red"));
        cars.add(new Car(2, "Reno", "White"));
        cars.add(new Car(3, "Vaz", "Black"));
        cars.add(new Car(4, "Ford", "Orange"));
        cars.add(new Car(5, "Honda", "Yellow"));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count < 0) {
            count = 0;
        }
        return cars.subList(0, Math.min(count, cars.size()));
    }
}
