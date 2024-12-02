package by.minsk.he.controller;

import by.minsk.he.dto.CarDto;
import by.minsk.he.mapper.CarMapper;
import by.minsk.he.models.CarModel;
import by.minsk.he.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/database/car")
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @PostMapping("/create")
    public CarDto create(
            @RequestBody CarDto carDto
    ) {
        CarModel car = carMapper.toCarModel(carDto);
        return carMapper.toCarDto(carService.insertCar(car));
    }

    @GetMapping("/find/{id}")
    public CarDto findCarById(
            @PathVariable(name = "id") UUID id
    ) {
        return carMapper.toCarDto(carService.findCarById(id));
    }

    @GetMapping("/find/all")
    public List<CarDto> readAll() {
        return carService.findAll()
                .stream()
                .map(carMapper::toCarDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update")
    public CarDto update(
            @RequestBody CarDto carDto
    ) {
        CarModel car = carMapper.toCarModel(carDto);
        return carMapper.toCarDto(carService.updateCar(car));
    }

    @DeleteMapping("/delete/{id}")
    public CarDto delete(
            @PathVariable(name = "id") UUID id
    ) {
        return carMapper.toCarDto(carService.deleteCar(id));
    }
}
