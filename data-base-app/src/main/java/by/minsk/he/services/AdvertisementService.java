package by.minsk.he.services;

import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.models.enums.CustomStatus;
import by.minsk.he.models.enums.EngineType;
import by.minsk.he.models.enums.RegionType;
import by.minsk.he.models.enums.TransmissionType;
import by.minsk.he.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

    public AdvertisementModel insertAdvertisement(AdvertisementModel advertisement) {
        return advertisementRepository.save(advertisement);
    }

    public AdvertisementModel findAdvertisementById(UUID id) {
        return advertisementRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Advertisement not found with id: " + id));
    }

    public List<AdvertisementModel> findAdvertisementsByCarBrand(String brand) {
        return Optional.ofNullable(
                        advertisementRepository.findByCarModel_Brand(brand))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByCarModel(String model) {
        return Optional.ofNullable(
                        advertisementRepository.findByCarModel_Model(model))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByCarYearBetween(int minCarYear, int maxCarYear) {
        return Optional.ofNullable(
                        advertisementRepository.findByCarModelYearBetween(minCarYear, maxCarYear))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByCarMileageLessThan(int carMileage) {
        return Optional.ofNullable(
                        advertisementRepository.findByCarModel_MileageLessThanEqual(carMileage))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        Sort sortByPrice = Sort.by(Sort.Direction.ASC, "price");
        return Optional.ofNullable(
                        advertisementRepository.findByPriceBetween(minPrice, maxPrice, sortByPrice))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByCarEngineTypeAndCapacityBetween(String type,
                                                                                        int minCapacity, int maxCapacity) {
        EngineType engineType = EngineType.fromString(type);
        return Optional.ofNullable(
                        advertisementRepository
                                .findByCarModelEngineTypeAndEngineCapacityBetween(engineType, minCapacity, maxCapacity))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByCarTransmissionType(String type) {
        TransmissionType transmissionType = TransmissionType.fromString(type);
        return Optional.ofNullable(
                        advertisementRepository
                                .findByCarModel_TransmissionType(transmissionType))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByRegionType(String type) {
        RegionType regionType = RegionType.fromString(type);
        return Optional.ofNullable(
                        advertisementRepository
                                .findByRegionType(regionType))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAdvertisementsByCarCustomStatus(String status) {
        CustomStatus customStatus = CustomStatus.fromString(status);
        return Optional.ofNullable(
                        advertisementRepository
                                .findByCarModel_CustomStatus(customStatus))
                .filter(list -> !list.isEmpty())
                .orElseThrow(NoSuchElementException::new);
    }

    public List<AdvertisementModel> findAll() {
        return advertisementRepository.findAllByOrderByAdvertStatusAscRankDesc();
    }


    public AdvertisementModel updateAdvertisement(AdvertisementModel advertisement) {
        if (!advertisementRepository.existsById(advertisement.getAdvertisementId())) {
            throw new NoSuchElementException("Advertisement not found with " + advertisement.getAdvertisementId());
        }
        return advertisementRepository.save(advertisement);
    }

    public AdvertisementModel deleteAdvertisement(UUID id) {
        AdvertisementModel advertisement = findAdvertisementById(id);
        advertisementRepository.delete(advertisement);
        return advertisement;
    }
}
