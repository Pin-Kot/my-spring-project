package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.CommentDto;
import by.minsk.he.dto.to_web_dto.CommentWebDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class, uses = {UserDtoMapper.class, AdvertisementDtoMapper.class})
public interface CommentDtoMapper {
    @Mapping(source = "advertisementDto", target = "advertisementWebDto")
    CommentWebDto toWebDto(CommentDto commentDto);
    @Mapping(source = "advertisementWebDto", target = "advertisementDto")
    CommentDto toDataBaseDto(CommentWebDto commentWebDto);
}
