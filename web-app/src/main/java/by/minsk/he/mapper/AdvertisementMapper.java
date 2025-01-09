package by.minsk.he.mapper;


import by.minsk.he.configuration.MapstructConfiguration;

import by.minsk.he.dto.AdvertisementWebDto;
import by.minsk.he.models.AdvertisementModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class, uses = {CarMapper.class, UserMapper.class})
public interface AdvertisementMapper {
    @Mapping(source = "carModel", target = "carWebDto")
    @Mapping(source = "userModel", target = "userWebDto")
    AdvertisementWebDto toAdvertisementDto(AdvertisementModel advertisementModel);
    @Mapping(source = "carWebDto", target = "carModel")
    @Mapping(source = "userWebDto", target = "userModel")
    AdvertisementModel toAdvertisementModel(AdvertisementWebDto advertisementWebDto);
}
