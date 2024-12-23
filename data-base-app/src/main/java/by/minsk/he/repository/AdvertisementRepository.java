package by.minsk.he.repository;

import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.models.enums.CustomStatus;
import by.minsk.he.models.enums.EngineType;
import by.minsk.he.models.enums.RegionType;
import by.minsk.he.models.enums.TransmissionType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface AdvertisementRepository extends JpaRepository<AdvertisementModel, UUID> {
    List<AdvertisementModel> findAllByOrderByAdvertStatusAscRankDesc();

    List<AdvertisementModel> findByCarModel_Brand(String brand);

    List<AdvertisementModel> findByCarModel_Model(String model);

    @Query("SELECT a FROM AdvertisementModel a WHERE a.carModel.year BETWEEN :minYear AND :maxYear")
    List<AdvertisementModel> findByCarModelYearBetween(int minYear, int maxYear);

    List<AdvertisementModel> findByCarModel_MileageLessThanEqual(int mileage);

    List<AdvertisementModel> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice, Sort sort);

    @Query("SELECT a FROM AdvertisementModel a WHERE a.carModel.engineType = :engineType " +
            "AND a.carModel.engineCapacity BETWEEN :minEngineCapacity AND :maxEngineCapacity")
    List<AdvertisementModel> findByCarModelEngineTypeAndEngineCapacityBetween(
            EngineType engineType, int minEngineCapacity, int maxEngineCapacity);

    List<AdvertisementModel> findByCarModel_TransmissionType(TransmissionType transmissionType);

    List<AdvertisementModel> findByRegionType(RegionType regionType);

    List<AdvertisementModel> findByCarModel_CustomStatus(CustomStatus customStatus);

}
