package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.UserDto;
import by.minsk.he.models.UserModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface UserMapper {
    UserDto toUserDto(UserModel userModel);
    UserModel toUserModel(UserDto userDto);
}
