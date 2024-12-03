package by.misk.he.stubs;

import by.minsk.he.models.CarModel;
import by.minsk.he.models.enums.BodyType;
import by.minsk.he.models.enums.CustomStatus;
import by.minsk.he.models.enums.EngineType;
import by.minsk.he.models.enums.TransmissionType;

import java.util.UUID;

public class CarStubs {
    public static final UUID CAR_ID= UUID.fromString("578bffaf-7cdb-4219-9bcd-005ae22fd890");
    public static final String BRAND = "SAAB";
    public static final String MODEL="9-5";
    public static final int YEAR = 1998;
    public static final int MILEAGE = 341000;
    public static final EngineType ENGINE_TYPE = EngineType.GASOLINE;
    public static final int ENGINE_CAPACITY = 1998;
    public static final TransmissionType TRANSMISSION_TYPE = TransmissionType.MANUAL;
    public static final BodyType BODY_TYPE = BodyType.SEDAN;
    public static final CustomStatus CUSTOM_STATUS = CustomStatus.CLEARED;

    public CarModel createCarStubs() {
        return CarModel.builder()
                .brand(BRAND)
                .model(MODEL)
                .year(YEAR)
                .mileage(MILEAGE)
                .engineType(ENGINE_TYPE)
                .engineCapacity(ENGINE_CAPACITY)
                .transmissionType(TRANSMISSION_TYPE)
                .bodyType(BODY_TYPE)
                .customStatus(CUSTOM_STATUS)
                .build();
    }
}
