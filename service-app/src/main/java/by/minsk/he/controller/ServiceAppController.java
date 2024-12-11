package by.minsk.he.controller;


import by.minsk.he.dto.to_web_dto.AdvertisementWebDto;
import by.minsk.he.dto.to_web_dto.CarWebDto;
import by.minsk.he.dto.to_web_dto.CommentWebDto;
import by.minsk.he.dto.to_web_dto.UserWebDto;
import by.minsk.he.mapper.AdvertisementDtoMapper;
import by.minsk.he.mapper.AdvertisementMapper;
import by.minsk.he.mapper.CarDtoMapper;
import by.minsk.he.mapper.CarMapper;
import by.minsk.he.mapper.CommentDtoMapper;
import by.minsk.he.mapper.CommentMapper;
import by.minsk.he.mapper.UserDtoMapper;
import by.minsk.he.mapper.UserMapper;
import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.models.CarModel;
import by.minsk.he.models.CommentModel;
import by.minsk.he.models.UserModel;
import by.minsk.he.service.BusinessService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping(path = "/business")
public class ServiceAppController {

    private final BusinessService businessService;
    private final AdvertisementMapper advertisementMapper;
    private final AdvertisementDtoMapper advertisementDtoMapper;
    private final CarMapper carMapper;
    private final CarDtoMapper carDtoMapper;
    private final CommentMapper commentMapper;
    private final CommentDtoMapper commentDtoMapper;
    private final UserMapper userMapper;
    private final UserDtoMapper userDtoMapper;

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

    @PostMapping("/car/create")
    public CarWebDto createCar(
            @RequestBody CarWebDto carWebDto
    ) {
        final CarModel car = carMapper
                .toCarModel(carDtoMapper.toDataBaseDto(carWebDto));
        return carDtoMapper.toWebDto(carMapper
                .toCarDto(businessService.createCar(car)));
    }

    @GetMapping("/car/find/{id}")
    public CarWebDto findCar(
            @PathVariable(name = "id")
            UUID carId
    ) {
        return carDtoMapper.toWebDto(carMapper
                .toCarDto(businessService.findCarById(carId)));
    }

    @PutMapping("/car/update")
    public CarWebDto updateCar(
            @RequestBody CarWebDto carWebDto) {
        final CarModel car = carMapper
                .toCarModel(carDtoMapper.toDataBaseDto(carWebDto));
        return carDtoMapper.toWebDto(carMapper
                .toCarDto(businessService.updateCar(car)));
    }

    @DeleteMapping("/car/delete/{id}")
    public CarWebDto deleteCar(
            @PathVariable(name = "id")
            UUID carId
    ) {
        return carDtoMapper.toWebDto(carMapper
                .toCarDto(businessService.deleteCar(carId)));
    }

    @PostMapping("/comment/create")
    public CommentWebDto createComment(
            @RequestBody CommentWebDto commentWebDto
    ) {
        final CommentModel comment = commentMapper
                .toCommentModel(commentDtoMapper.toDataBaseDto(commentWebDto));
        return commentDtoMapper.toWebDto(commentMapper
                .toCommentDto(businessService.createComment(comment)));
    }

    @GetMapping("/comment/find/{id}")
    public CommentWebDto findComment(
            @PathVariable(name = "id")
            UUID commentId
    ) {
        return commentDtoMapper.toWebDto(commentMapper
                .toCommentDto(businessService.findCommentById(commentId)));
    }

    @PutMapping("/comment/update")
    public CommentWebDto updateComment(
            @RequestBody CommentWebDto commentWebDto) {
        final CommentModel comment = commentMapper
                .toCommentModel(commentDtoMapper.toDataBaseDto(commentWebDto));
        return commentDtoMapper.toWebDto(commentMapper
                .toCommentDto(businessService.updateComment(comment)));
    }

    @DeleteMapping("/comment/delete/{id}")
    public CommentWebDto deleteComment(
            @PathVariable(name = "id")
            UUID commentId
    ) {
        return commentDtoMapper.toWebDto(commentMapper
                .toCommentDto(businessService.deleteComment(commentId)));
    }

    @PostMapping("/user/create")
    public UserWebDto createUser(
            @RequestBody UserWebDto userWebDto
    ) {
        final UserModel user = userMapper
                .toUserModel(userDtoMapper.toDataBaseDto(userWebDto));
        return userDtoMapper.toWebDto(userMapper
                .toUserDto(businessService.createUser(user)));
    }

    @GetMapping("/user/find/{id}")
    public UserWebDto findUser(
            @PathVariable(name = "id")
            UUID userId
    ) {
        return userDtoMapper.toWebDto(userMapper
                .toUserDto(businessService.findUserById(userId)));
    }

    @PutMapping("/user/update")
    public UserWebDto updateUser(
            @RequestBody UserWebDto userWebDto) {
        final UserModel user = userMapper
                .toUserModel(userDtoMapper.toDataBaseDto(userWebDto));
        return userDtoMapper.toWebDto(userMapper
                .toUserDto(businessService.updateUser(user)));
    }

    @DeleteMapping("/user/delete/{id}")
    public UserWebDto deleteUser(
            @PathVariable(name = "id")
            UUID userId
    ) {
        return userDtoMapper.toWebDto(userMapper
                .toUserDto(businessService.deleteUser(userId)));
    }

}
