package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAOImpl  implements CarDAO {
    private final List<Car> cars;

    public CarDAOImpl() {
        cars = getAllCars();
    }

    @Override
    public List<Car> getAllCars() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Kia", "Red"));
        cars.add(new Car(2, "Reno", "White"));
        cars.add(new Car(3, "Vaz", "Black"));
        cars.add(new Car(4, "Ford", "Orange"));
        cars.add(new Car(5, "Honda", "Yellow"));
        return cars;
    }
    @Override
    public List<Car> getCars(int count) {
        if (count <= 0) {
            return new ArrayList<>(); // Возвращаем пустой список, если count <= 0
        }
        return cars.subList(0, Math.min(count, cars.size())); // Возвращаем подсписок
    }
}
/*Метод subList(int fromIndex, int toIndex) — это метод интерфейса List в Java,
 который возвращает представление части списка (подсписка) в виде нового списка.*/