package by.minsk.he.services;

import by.minsk.he.models.CarModel;
import by.minsk.he.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CarService {

    private final CarRepository carRepository;

    public CarModel insertCar(CarModel car) {
        return carRepository.save(car);
    }

    public CarModel findCarById(UUID id) {
        return carRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Car not found with id: " + id));
    }

    public List<CarModel> findAll() {
        return carRepository.findAll();
    }


    public CarModel updateCar(CarModel car) {
        if (!carRepository.existsById(car.getCarId())) {
            throw new NoSuchElementException("Car not found with " + car.getCarId());
        }
        return carRepository.save(car);
    }

    @Transactional
    public CarModel deleteCar(UUID id){
        CarModel carFromBase = findCarById(id);
        carRepository.delete(carFromBase);
        return carFromBase;
    }
}
