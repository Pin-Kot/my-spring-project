package by.minsk.he.mapper;


import by.minsk.he.configuration.MapstructConfiguration;

import by.minsk.he.dto.CardWebDto;
import by.minsk.he.models.CardModel;
import org.mapstruct.Mapper;

@Mapper(config = MapstructConfiguration.class)
public interface CardMapper {
    CardWebDto toCardDto(CardModel card);
    CardModel toCarModel(CardWebDto cardWebDto);
}
