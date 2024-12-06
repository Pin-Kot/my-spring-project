package by.minsk.he.dto.to_data_base_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AdvertisementDto {
    private UUID advertisementId;
    private LocalDate startDate;
    private String contactPhone;
    private BigDecimal price;
    private int rank;
    private String regionType;
    private String advertStatus;
    private CarDto carDto;
    private UserDto userDto;
}
