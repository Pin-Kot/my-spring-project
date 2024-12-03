package by.misk.he.stubs;

import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.models.CarModel;
import by.minsk.he.models.UserModel;
import by.minsk.he.models.enums.AdvertStatus;
import by.minsk.he.models.enums.RegionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class AdvertisementStubs {

    public static final UUID ADVERTISEMENT_ID = UUID.fromString("c5e6f7d8-a9d1-4b7b-8e5f-d1f3e6a7c5a4");
    public static final LocalDate START_DATE = LocalDate.of(2024, 1, 1);
    public static final String CONTRACT_PHONE = "+375255555555";
    public static final BigDecimal PRICE = BigDecimal.valueOf(3200);
    public static final int RANK = 0;
    public static final RegionType REGION_TYPE = RegionType.MINSK;
    public static final AdvertStatus ADVERT_STATUS = AdvertStatus.STANDARD;
    public static final CarModel CAR  = new CarModel();
    public static final UserModel USER = new UserModel();

    public AdvertisementModel createAdvertisementStubs() {
        return AdvertisementModel.builder()
                .startDate(START_DATE)
                .contactPhone(CONTRACT_PHONE)
                .price(PRICE)
                .rank(RANK)
                .regionType(REGION_TYPE)
                .advertStatus(ADVERT_STATUS)
                .carModel(CAR)
                .userModel(USER)
                .build();
    }
}
