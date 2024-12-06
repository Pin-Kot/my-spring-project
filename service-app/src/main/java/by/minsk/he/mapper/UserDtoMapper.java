package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.UserDto;
import by.minsk.he.dto.to_web_dto.UserWebDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface UserDtoMapper {
    UserWebDto toWebDto(UserDto userDbDto);
    UserDto toDataBaseDto(UserWebDto userWebDto);
}
