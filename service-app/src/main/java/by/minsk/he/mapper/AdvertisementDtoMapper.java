package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.AdvertisementDto;
import by.minsk.he.dto.to_web_dto.AdvertisementWebDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class, uses = {CarDtoMapper.class, UserDtoMapper.class})
public interface AdvertisementDtoMapper {
    @Mapping(source = "carDto", target = "carWebDto")
    @Mapping(source = "userDto", target = "userWebDto")
    AdvertisementWebDto toWebDto(AdvertisementDto advertisementModel);
    @Mapping(source = "carWebDto", target = "carDto")
    @Mapping(source = "userWebDto", target = "userDto")
    AdvertisementDto toDataBaseDto(AdvertisementWebDto advertisementWebDto);
}
