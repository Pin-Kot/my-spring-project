package by.minsk.he.mapper;

import by.minsk.he.config.MapstructConfiguration;
import by.minsk.he.dto.to_data_base_dto.CommentDto;
import by.minsk.he.models.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class, uses = {UserMapper.class, AdvertisementMapper.class})
public interface CommentMapper {
    @Mapping(source = "advertisementModel", target = "advertisementDto")
    CommentDto toCommentDto(CommentModel commentModel);
    @Mapping(source = "advertisementDto", target = "advertisementModel")
    CommentModel toCommentModel(CommentDto commentDto);
}
