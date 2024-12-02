package by.minsk.he.models;
import by.minsk.he.models.enums.BodyType;
import by.minsk.he.models.enums.EngineType;
import by.minsk.he.models.enums.TransmissionType;
import by.minsk.he.models.enums.CustomStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID carId;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    private int engineCapacity;
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;
    @Enumerated(EnumType.STRING)
    private BodyType bodyType;
    @Enumerated(EnumType.STRING)
    private CustomStatus customStatus;
}
