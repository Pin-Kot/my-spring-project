package by.minsk.he.models;

import by.minsk.he.models.enums.BodyType;
import by.minsk.he.models.enums.CustomStatus;
import by.minsk.he.models.enums.EngineType;
import by.minsk.he.models.enums.TransmissionType;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CarModel {

    private UUID carId;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private EngineType engineType;
    private int engineCapacity;
    private TransmissionType transmissionType;
    private BodyType bodyType;
    private CustomStatus customStatus;
}
