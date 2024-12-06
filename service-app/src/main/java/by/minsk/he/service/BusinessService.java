package by.minsk.he.service;

import by.minsk.he.dto.to_data_base_dto.AdvertisementDto;
import by.minsk.he.dto.to_data_base_dto.CarDto;
import by.minsk.he.mapper.AdvertisementMapper;
import by.minsk.he.mapper.CarMapper;
import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.models.CarModel;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BusinessService {

    private static final String ROOT_ADVERTISEMENT = "/advertisement";
    private static final String ROOT_USER = "/user";
    private static final String ROOT_CAR = "/car";
    private static final String ROOT_COMMENT = "/comment";

    private static final String METHOD_CREATE = "/create";
    private static final String METHOD_FIND = "/find/";
    private static final String METHOD_FIND_ALL = "/find/all";
    private static final String METHOD_UPDATE = "/update";
    private static final String METHOD_DELETE = "/delete/";

    private final RestTemplate restTemplate;
    private final AdvertisementMapper advertisementMapper;
    private final CarMapper carMapper;

    public AdvertisementModel createAdvertisement(AdvertisementModel advertisementModel) {
        AdvertisementDto advertisementDto = advertisementMapper.toAdvertisementDto(advertisementModel);
        return advertisementMapper.toAdvertisementModel(restTemplate.postForObject(buildUrl(ROOT_ADVERTISEMENT, METHOD_CREATE),
                advertisementDto, AdvertisementDto.class));
    }

    public AdvertisementModel findAdvertisementById(UUID id) {
        AdvertisementDto advertisementDto = restTemplate.getForObject(buildUrl(ROOT_ADVERTISEMENT, METHOD_FIND) + id, AdvertisementDto.class);
        return advertisementMapper.toAdvertisementModel(advertisementDto);
    }

    public List<AdvertisementModel> findAllAdvertisements() {
        ResponseEntity<List<AdvertisementDto>> response = restTemplate.exchange(
                buildUrl(ROOT_ADVERTISEMENT, METHOD_FIND_ALL),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {}
        );
        return Objects.requireNonNull(response.getBody()).stream()
                .map(advertisementMapper::toAdvertisementModel)
                .collect(Collectors.toList());
    }

    public AdvertisementModel updateAdvertisement(AdvertisementModel advertisementModel) {
        AdvertisementDto advertisementDto = advertisementMapper.toAdvertisementDto(advertisementModel);
        restTemplate.put(buildUrl(ROOT_ADVERTISEMENT, METHOD_UPDATE), advertisementDto, AdvertisementDto.class);
        return findAdvertisementById(advertisementModel.getAdvertisementId());
    }

    public AdvertisementModel deleteAdvertisement(UUID id) {
        AdvertisementModel advertisement = findAdvertisementById(id);
        restTemplate.delete(buildUrl(ROOT_ADVERTISEMENT, METHOD_DELETE) + id);
        return advertisement;
    }

    public CarModel createCar(CarModel carModel) {
        CarDto carDto = carMapper.toCarDto(carModel);
        return carMapper.toCarModel(restTemplate.postForObject(buildUrl(ROOT_CAR, METHOD_CREATE),
                carDto, CarDto.class));
    }

    private String buildUrl(String root, String method) {
        return root.concat(method);
    }
}
