package by.minsk.he.service;

import by.minsk.he.dto.to_data_base_dto.AdvertisementDto;
import by.minsk.he.dto.to_data_base_dto.CarDto;
import by.minsk.he.dto.to_data_base_dto.CommentDto;
import by.minsk.he.dto.to_data_base_dto.UserDto;
import by.minsk.he.mapper.AdvertisementMapper;
import by.minsk.he.mapper.CarMapper;
import by.minsk.he.mapper.CommentMapper;
import by.minsk.he.mapper.UserMapper;
import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.models.CarModel;
import by.minsk.he.models.CommentModel;
import by.minsk.he.models.UserModel;
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
    private final CommentMapper commentMapper;
    private final UserMapper userMapper;

    public AdvertisementModel createAdvertisement(AdvertisementModel advertisementModel) {
        AdvertisementDto advertisementDto = advertisementMapper.toAdvertisementDto(advertisementModel);
        return advertisementMapper.toAdvertisementModel(restTemplate.postForObject(
                buildUrl(ROOT_ADVERTISEMENT, METHOD_CREATE),
                advertisementDto, AdvertisementDto.class));
    }

    public AdvertisementModel findAdvertisementById(UUID id) {
        AdvertisementDto advertisementDto = restTemplate.getForObject(
                buildUrlWithId(ROOT_ADVERTISEMENT, METHOD_FIND, id), AdvertisementDto.class);
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
        restTemplate.delete(buildUrlWithId(ROOT_ADVERTISEMENT, METHOD_DELETE, id));
        return advertisement;
    }

    public CarModel createCar(CarModel carModel) {
        CarDto carDto = carMapper.toCarDto(carModel);
        return carMapper.toCarModel(restTemplate.postForObject(buildUrl(ROOT_CAR, METHOD_CREATE),
                carDto, CarDto.class));
    }

    public CarModel findCarById(UUID id) {
        CarDto carDto = restTemplate.getForObject(buildUrlWithId(ROOT_CAR, METHOD_FIND, id), CarDto.class);
        return carMapper.toCarModel(carDto);
    }

    public CarModel updateCar(CarModel carModel) {
        CarDto carDto = carMapper.toCarDto(carModel);
        restTemplate.put(buildUrl(ROOT_CAR, METHOD_UPDATE), carDto, CarDto.class);
        return findCarById(carModel.getCarId());
    }

    public CarModel deleteCar(UUID id) {
        CarModel car = findCarById(id);
        restTemplate.delete(buildUrlWithId(ROOT_CAR, METHOD_DELETE, id));
        return car;
    }

    public CommentModel createComment(CommentModel comment) {
        CommentDto commentDto = commentMapper.toCommentDto(comment);
        return commentMapper.toCommentModel(restTemplate.postForObject(buildUrl(ROOT_COMMENT, METHOD_CREATE),
                commentDto, CommentDto.class));
    }

    public CommentModel findCommentById(UUID id) {
        CommentDto commentDto = restTemplate.getForObject(buildUrlWithId(ROOT_COMMENT, METHOD_FIND, id), CommentDto.class);
        return commentMapper.toCommentModel(commentDto);
    }

    public CommentModel updateComment(CommentModel commentModel) {
        CommentDto commentDto = commentMapper.toCommentDto(commentModel);
        restTemplate.put(buildUrl(ROOT_COMMENT, METHOD_UPDATE), commentDto, CommentDto.class);
        return findCommentById(commentModel.getCommentId());
    }

    public CommentModel deleteComment(UUID id) {
        CommentModel comment = findCommentById(id);
        restTemplate.delete(buildUrlWithId(ROOT_COMMENT, METHOD_DELETE, id));
        return comment;
    }

    public UserModel createUser(UserModel userModel) {
        UserDto userDto = userMapper.toUserDto(userModel);
        return userMapper.toUserModel(restTemplate.postForObject(buildUrl(ROOT_USER, METHOD_CREATE),
                userDto, UserDto.class));
    }

    public UserModel findUserById(UUID id) {
        UserDto userDto = restTemplate.getForObject(buildUrlWithId(ROOT_USER, METHOD_FIND, id),
                UserDto.class);
        return userMapper.toUserModel(userDto);
    }

    public UserModel updateUser(UserModel userModel) {
        UserDto userDto = userMapper.toUserDto(userModel);
        restTemplate.put(buildUrl(ROOT_USER, METHOD_UPDATE), userDto, UserDto.class);
        return findUserById(userModel.getUserId());
    }

    public UserModel deleteUser(UUID id) {
        UserModel user = findUserById(id);
        restTemplate.delete(buildUrlWithId(ROOT_USER, METHOD_DELETE, id));
        return user;
    }

    private String buildUrl(String root, String method) {
        return root.concat(method);
    }

    private String buildUrlWithId(String root, String method, UUID id) {
        return root.concat(method).concat(id.toString());
    }
}
