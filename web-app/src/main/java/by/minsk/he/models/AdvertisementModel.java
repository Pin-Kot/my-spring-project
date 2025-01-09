package by.minsk.he.models;

import by.minsk.he.models.enums.AdvertStatus;
import by.minsk.he.models.enums.RegionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AdvertisementModel {
    private UUID advertisementId;
    private LocalDate startDate;
    private String contactPhone;
    private BigDecimal price;
    private int rank;
    private RegionType regionType;
    private AdvertStatus advertStatus;
    private CarModel carModel;
    private UserModel userModel;
}
