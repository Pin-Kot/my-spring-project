package by.minsk.he.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CommentDto {
    private UUID commentId;
    private LocalDateTime created;
    private String content;
    private UserDto userDto;
    private AdvertisementDto advertisementDto;
}
