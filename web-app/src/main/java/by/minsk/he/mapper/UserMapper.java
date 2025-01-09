package by.minsk.he.mapper;


import by.minsk.he.configuration.MapstructConfiguration;
import by.minsk.he.dto.UserWebDto;
import by.minsk.he.models.UserModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface UserMapper {
    UserWebDto toUserDto(UserModel userModel);
    UserModel toUserModel(UserWebDto userWebDto);
}
