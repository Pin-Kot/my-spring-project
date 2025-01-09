package by.minsk.he.mapper;


import by.minsk.he.configuration.MapstructConfiguration;
import by.minsk.he.dto.CommentWebDto;
import by.minsk.he.models.CommentModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapstructConfiguration.class, uses = {UserMapper.class, AdvertisementMapper.class})
public interface CommentMapper {
    @Mapping(source = "advertisementModel", target = "advertisementWebDto")
    CommentWebDto toCommentDto(CommentModel commentModel);
    @Mapping(source = "advertisementWebDto", target = "advertisementModel")
    CommentModel toCommentModel(CommentWebDto commentWebDto);
}
