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
import org.springframework.web.bind.annotation.RestController;

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
