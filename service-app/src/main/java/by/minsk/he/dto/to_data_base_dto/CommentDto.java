package by.minsk.he.dto.to_data_base_dto;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDto {
    private UUID commentId;
    private ZonedDateTime created;
    private String content;
    private UUID userId;
    private AdvertisementDto advertisementDto;
}
