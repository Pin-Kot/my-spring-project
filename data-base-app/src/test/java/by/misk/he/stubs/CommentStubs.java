package by.misk.he.stubs;

import by.minsk.he.models.AdvertisementModel;
import by.minsk.he.models.CommentModel;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class CommentStubs {

    public static final UUID COMMENT_ID = UUID.fromString("96ef8383-781c-4e7f-afba-f8d00fe63d24");
    public static final ZonedDateTime CREATED = ZonedDateTime.of(2024, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC"));
    public static final String CONTENT = "FUNNY COMMENT";
    public static final UUID USER_ID = UUID.fromString("fb9171d8-ee7e-44fe-9c3b-009efc5bb99e");
    public static final AdvertisementModel ADVERTISEMENT = new AdvertisementModel();

    public CommentModel createCommentStubs() {
        return CommentModel.builder()
                .created(CREATED)
                .content(CONTENT)
                .userId(USER_ID)
                .advertisementModel(ADVERTISEMENT)
                .build();
    }
}
