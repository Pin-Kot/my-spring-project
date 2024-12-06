package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.CarDto;
import by.minsk.he.dto.to_web_dto.CarWebDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface CarDtoMapper {
    CarWebDto toWebDto(CarDto carDto);
    CarDto toDataBaseDto(CarWebDto carWebDto);
}
