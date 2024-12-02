package by.minsk.he.controller;

import by.minsk.he.dto.UserDto;
import by.minsk.he.mapper.UserMapper;
import by.minsk.he.models.UserModel;
import by.minsk.he.services.UserService;
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
@RequestMapping(path = "/database/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping("/create")
    public UserDto create(
            @RequestBody UserDto userDto
    ) {
        UserModel user = userMapper.toUserModel(userDto);
        return userMapper.toUserDto(userService.insertUser(user));
    }

    @GetMapping("/find/{id}")
    public UserDto findUserById(
            @PathVariable(name = "id") UUID id
    ) {
        return userMapper.toUserDto(userService.findUserById(id));
    }

    @GetMapping("/find/all")
    public List<UserDto> readAll() {
        return userService.findAll()
                .stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/update")
    public UserDto update(
            @RequestBody UserDto userDto
    ) {
        UserModel car = userMapper.toUserModel(userDto);
        return userMapper.toUserDto(userService.updateUser(car));
    }

    @DeleteMapping("/delete/{id}")
    public UserDto delete(
            @PathVariable(name = "id") UUID id
    ) {
        return userMapper.toUserDto(userService.deleteUser(id));
    }
}
