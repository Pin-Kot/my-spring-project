package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.CommentDto;
import by.minsk.he.models.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class, uses = {UserMapper.class, AdvertisementMapper.class})
public interface CommentMapper {
    @Mapping(source = "userModel", target = "userDto")
    @Mapping(source = "advertisementModel", target = "advertisementDto")
    CommentDto toCommentDto(CommentModel car);
    @Mapping(source = "userDto", target = "userModel")
    @Mapping(source = "advertisementDto", target = "advertisementModel")
    CommentModel toCommentModel(CommentDto carDto);
}
