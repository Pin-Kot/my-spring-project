package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.CardDto;
import by.minsk.he.models.CardModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface CardMapper {
    CardDto toCardDto(CardModel card);
    CardModel toCarModel(CardDto cardDto);
}
