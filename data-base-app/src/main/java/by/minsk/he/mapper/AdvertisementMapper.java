package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.AdvertisementDto;
import by.minsk.he.models.AdvertisementModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class, uses = {CarMapper.class, UserMapper.class})
public interface AdvertisementMapper {
    @Mapping(source = "carModel", target = "carDto")
    @Mapping(source = "userModel", target = "userDto")
    AdvertisementDto toAdvertisementDto(AdvertisementModel car);
    @Mapping(source = "carDto", target = "carModel")
    @Mapping(source = "userDto", target = "userModel")
    AdvertisementModel toAdvertisementModel(AdvertisementDto carDto);
}
