package by.minsk.he.mapper;


import by.minsk.he.configuration.MapstructConfiguration;

import by.minsk.he.dto.CarWebDto;
import by.minsk.he.models.CarModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface CarMapper {
    CarWebDto toCarDto(CarModel car);
    CarModel toCarModel(CarWebDto carWebDto);
}
