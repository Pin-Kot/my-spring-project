package by.minsk.he.controller;


import by.minsk.he.dto.to_web_dto.AdvertisementWebDto;
import by.minsk.he.mapper.AdvertisementDtoMapper;
import by.minsk.he.mapper.AdvertisementMapper;
import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.service.BusinessService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/business")
public class ServiceAppController {

    private final BusinessService businessService;
    private final AdvertisementMapper advertisementMapper;
    private final AdvertisementDtoMapper advertisementDtoMapper;

    @PostMapping("/advertisement/create")
    public AdvertisementWebDto createAdvertisement(
            @RequestBody AdvertisementWebDto advertisementWebDto
    ) {
        final AdvertisementModel advertisement = advertisementMapper
                .toAdvertisementModel(advertisementDtoMapper.toDataBaseDto(advertisementWebDto));
        return advertisementDtoMapper.toWebDto(advertisementMapper
                .toAdvertisementDto(businessService.createAdvertisement(advertisement)));
    }

    @GetMapping("/advertisement/find/{id}")
    public AdvertisementWebDto findAdvertisement(
            @PathVariable(name = "id")
            UUID advertId
    ) {
        return advertisementDtoMapper.toWebDto(advertisementMapper
                .toAdvertisementDto(businessService.findAdvertisementById(advertId)));
    }

    @GetMapping("/advertisement/find/all")
    public List<AdvertisementWebDto> findAdvertisements() {
        return businessService.findAllAdvertisements().stream()
                .map(advertisementMapper::toAdvertisementDto)
                .map(advertisementDtoMapper::toWebDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/advertisement/update")
    public AdvertisementWebDto updateAdvertisement(
            @RequestBody AdvertisementWebDto advertisementWebDto
    ) {
        final AdvertisementModel advertisement = advertisementMapper
                .toAdvertisementModel(advertisementDtoMapper.toDataBaseDto(advertisementWebDto));
        return advertisementDtoMapper.toWebDto(advertisementMapper
                        .toAdvertisementDto(businessService.updateAdvertisement(advertisement))
        );
    }

    @DeleteMapping("/advertisement/delete/{id}")
    public AdvertisementWebDto deleteAdvertisement(
            @PathVariable(name = "id")
            UUID advertId
    ) {
        return advertisementDtoMapper.toWebDto(advertisementMapper
                .toAdvertisementDto(businessService.deleteAdvertisement(advertId)));
    }
}
