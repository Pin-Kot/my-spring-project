package by.minsk.he.dto;

import lombok.*;

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
