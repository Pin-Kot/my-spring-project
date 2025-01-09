package by.minsk.he.models;

import lombok.*;

import java.time.ZonedDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentModel {

    private UUID commentId;
    private ZonedDateTime created;
    private String content;
    private UUID userId;
    private AdvertisementModel advertisementModel;
}