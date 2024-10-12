package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    List<Car> myAutoPark;

    public CarService() {
        myAutoPark = new ArrayList<>();
        myAutoPark.add(new Car("Audi A8", 2017, 400));
        myAutoPark.add(new Car("Lada Sidan", 2010, 1000));
        myAutoPark.add(new Car("Tayota Camri", 2015, 800));
        myAutoPark.add(new Car("Mersedes Benz", 2020, 900));
        myAutoPark.add(new Car("BMW M8", 2014, 800));
    }

    public List<Car> getMyAutoPark() {
        return myAutoPark;
    }

    public List<Car> getRentedCars(int numbersOfCarsNeeded) {
        if (numbersOfCarsNeeded < 5) {
            return myAutoPark.subList(0, numbersOfCarsNeeded);
        }
        return myAutoPark;
    }
}
