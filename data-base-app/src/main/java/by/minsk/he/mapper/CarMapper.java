package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.CarDto;
import by.minsk.he.models.CarModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface CarMapper {
    CarDto toCarDto(CarModel car);
    CarModel toCarModel(CarDto carDto);
}
