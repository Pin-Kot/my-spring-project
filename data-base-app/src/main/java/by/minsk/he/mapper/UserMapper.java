package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.UserDto;
import by.minsk.he.models.UserModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class, uses = AdvertisementMapper.class)
public interface UserMapper {
    UserDto toUserDto(UserModel car);
    UserModel toUserModel(UserDto carDto);
}