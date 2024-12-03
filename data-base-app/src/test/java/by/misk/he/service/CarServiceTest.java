package by.misk.he.service;

import by.minsk.he.models.CarModel;
import by.minsk.he.repository.CarRepository;
import by.minsk.he.services.CarService;
import by.misk.he.stubs.CarStubs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static by.misk.he.stubs.CarStubs.CAR_ID;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    private final CarStubs carStubsTest = new CarStubs();

    @Test
    void insertCar_then_return() {

        CarModel testCar = carStubsTest.createCarStubs();

        when(carRepository.save(
                        eq(testCar)
                )
        ).thenReturn(
                testCar
        );
        CarModel actualCar = carService.insertCar(testCar);
        Assertions.assertEquals(actualCar, testCar);
        verify(carRepository, new Times(1)).save(testCar);
    }

    @Test
    void insertCar_then_throws_exception() {

        CarModel testCar = carStubsTest.createCarStubs();

        when(carRepository.save(
                        eq(testCar)
                )
        ).thenThrow(new RuntimeException("") {
        });
        assertThrows(RuntimeException.class, () -> carService.insertCar(testCar));
        verify(carRepository, new Times(1)).save(testCar);
    }

    @Test
    void findCarById_then_return() {

        CarModel testCar = carStubsTest.createCarStubs();
        testCar.setCarId(CAR_ID);

        when(carRepository.findById(
                        eq(CAR_ID)
                )
        ).thenReturn(
                Optional.of(testCar)
        );
        CarModel actualCar = carService.findCarById(CAR_ID);
        Assertions.assertEquals(actualCar, testCar);
        verify(carRepository, new Times(1)).findById(CAR_ID);
    }

    @Test
    void findCarById_then_throws_exception() {

        when(carRepository.findById(
                eq(CAR_ID))
        ).thenThrow(new IllegalArgumentException("") {
        });
        assertThrows(IllegalArgumentException.class, () -> carService.findCarById(CAR_ID));
        verify(carRepository, new Times(1)).findById(CAR_ID);
    }

    @Test
    void findAll_then_return() {

        CarModel testCar1 = carStubsTest.createCarStubs();
        CarModel testCar2 = carStubsTest.createCarStubs();
        List<CarModel> testList = new ArrayList<>(Arrays.asList(testCar1, testCar2));

        when(carRepository.findAll()
        ).thenReturn(
                testList
        );
        List<CarModel> actualList = carService.findAll();
        Assertions.assertIterableEquals(actualList, testList);
        verify(carRepository, new Times(1)).findAll();
    }

    @Test
    void updateCar_then_return() {

        CarModel testCar = carStubsTest.createCarStubs();
        testCar.setCarId(CAR_ID);

        when(carRepository.existsById(
                testCar.getCarId())
        ).thenReturn(true);

        when(carRepository.save(
                eq(testCar))
        ).thenReturn(
                testCar
        );
        CarModel actualCar = carService.updateCar(testCar);
        Assertions.assertEquals(actualCar, testCar);

        verify(carRepository, new Times(1)).existsById(CAR_ID);
        verify(carRepository, new Times(1)).save(testCar);
    }

    @Test
    void updateCar_then_throws_exception() {

        CarModel testCar = carStubsTest.createCarStubs();
        testCar.setCarId(CAR_ID);

        when(carRepository.existsById(
               CAR_ID)
        ).thenThrow(new NoSuchElementException("") {
        });
        assertThrows(NoSuchElementException.class, () -> carService.updateCar(testCar));
        verify(carRepository, new Times(1)).existsById(CAR_ID);
        verify(carRepository, new Times(0)).save(testCar);
    }

    @Test
    void deleteCar_then_return() {

        CarModel testCar = carStubsTest.createCarStubs();
        testCar.setCarId(CAR_ID);

        when(carRepository.findById(
                        eq(CAR_ID)
                )
        ).thenReturn(
                Optional.of(testCar)
        );
        doNothing().when(carRepository).delete(testCar);

        CarModel actualCar = carService.deleteCar(CAR_ID);
        Assertions.assertEquals(actualCar, testCar);
        verify(carRepository, new Times(1)).findById(CAR_ID);
        verify(carRepository, new Times(1)).delete(testCar);
    }
}
