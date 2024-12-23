package by.minsk.he.controller;

import by.minsk.he.dto.AdvertisementDto;
import by.minsk.he.mapper.AdvertisementMapper;
import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.services.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/database/advertisement")
public class AdvertisementController {
    private final AdvertisementService advertisementService;
    private final AdvertisementMapper advertisementMapper;

    @PostMapping("/create")
    public AdvertisementDto create(
            @RequestBody AdvertisementDto advertisementDto
    ) {
        AdvertisementModel advertisement = advertisementMapper.toAdvertisementModel(advertisementDto);
        return advertisementMapper.toAdvertisementDto(advertisementService.insertAdvertisement(advertisement));
    }

    @GetMapping("/find/{id}")
    public AdvertisementDto findAdvertisementById(
            @PathVariable(name = "id") UUID id
    ) {
        return advertisementMapper.toAdvertisementDto(advertisementService.findAdvertisementById(id));
    }

    @GetMapping("/find/by_car/by_brand/{carBrand}")
    public List<AdvertisementDto> findAdvertisementByCarBrand(
            @PathVariable(name = "carBrand") String carBrand
    ) {
        return advertisementService.findAdvertisementsByCarBrand(carBrand)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_car/by_model/{carModel}")
    public List<AdvertisementDto> findAdvertisementByCarModel(
            @PathVariable(name = "carModel") String carModel
    ) {
        return advertisementService.findAdvertisementsByCarModel(carModel)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_car/by_year/between")
    public List<AdvertisementDto> findAdvertisementByCarYearBetween(
            @RequestParam(name = "minCarYear") int minCarYear,
            @RequestParam(name = "maxCarYear") int maxCarYear
    ) {
        return advertisementService.findAdvertisementsByCarYearBetween(minCarYear, maxCarYear)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_car/by_mileage/less_than/{carMileage}")
    public List<AdvertisementDto> findAdvertisementByCarMileageLessThan(
            @PathVariable(name = "carMileage") int carMileage
    ) {
        return advertisementService.findAdvertisementsByCarMileageLessThan(carMileage)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_price/between")
    public List<AdvertisementDto> findAdvertisementByPriceBetween(
            @RequestParam(name = "minPrice") BigDecimal minPrice,
            @RequestParam(name = "maxPrice") BigDecimal maxPrice
    ) {
        return advertisementService.findAdvertisementsByPriceBetween(minPrice, maxPrice)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_car/by_engine/by_capacity/between")
    public List<AdvertisementDto> findAdvertisementByCarEngineTypeAndEngineCapacityBetween(
            @RequestParam(name = "engineType") String engineType,
            @RequestParam(name = "minCapacity") int minCapacity,
            @RequestParam(name = "maxCapacity") int maxCapacity
    ) {
        return advertisementService
                .findAdvertisementsByCarEngineTypeAndCapacityBetween(engineType, minCapacity, maxCapacity)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_car/by_transmission")
    public List<AdvertisementDto> findAdvertisementByCarTransmissionType(
            @RequestParam(name = "transmissionType") String transmissionType
    ) {
        return advertisementService
                .findAdvertisementsByCarTransmissionType(transmissionType)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_region")
    public List<AdvertisementDto> findAdvertisementByRegionType(
            @RequestParam(name = "regionType") String regionType
    ) {
        return advertisementService
                .findAdvertisementsByRegionType(regionType)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/by_car/by_custom_status")
    public List<AdvertisementDto> findAdvertisementByCarCustomStatus(
            @RequestParam(name = "customStatus") String customStatus
    ) {
        return advertisementService
                .findAdvertisementsByCarCustomStatus(customStatus)
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/find/all")
    public List<AdvertisementDto> readAll() {
        return advertisementService.findAll()
                .stream()
                .map(advertisementMapper::toAdvertisementDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update")
    public AdvertisementDto update(
            @RequestBody AdvertisementDto advertisementDto
    ) {
        AdvertisementModel advertisement = advertisementMapper.toAdvertisementModel(advertisementDto);
        return advertisementMapper.toAdvertisementDto(advertisementService.updateAdvertisement(advertisement));
    }

    @DeleteMapping("/delete/{id}")
    public AdvertisementDto delete(
            @PathVariable(name = "id") UUID id
    ) {
        return advertisementMapper.toAdvertisementDto(advertisementService.deleteAdvertisement(id));
    }
}
