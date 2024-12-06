package by.minsk.he.dto.to_web_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CarWebDto {
    private UUID carId;
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private String engineType;
    private int engineCapacity;
    private String transmissionType;
    private String bodyType;
    private String customStatus;
}
