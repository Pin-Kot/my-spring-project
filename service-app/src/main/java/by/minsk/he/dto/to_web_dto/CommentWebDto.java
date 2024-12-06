package by.minsk.he.dto.to_web_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentWebDto {
    private UUID commentId;
    private ZonedDateTime created;
    private String content;
    private UUID userId;
    private AdvertisementWebDto advertisementWebDto;
}
