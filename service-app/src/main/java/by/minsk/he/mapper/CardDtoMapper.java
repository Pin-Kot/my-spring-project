package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.CardDto;
import by.minsk.he.dto.to_web_dto.CardWebDto;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface CardDtoMapper {
    CardWebDto toWebDto(CardDto cardDto);
    CardDto toDataBaseDto(CardWebDto cardWebDto);
}
