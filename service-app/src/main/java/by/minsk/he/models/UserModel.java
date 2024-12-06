package by.minsk.he.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserModel {

    private UUID userId;
    private String login;
    private String password;
    private String nickname;
    private String mobilePhone;
    private BigDecimal balance;
    private List<UUID> favoritesAdvertisementId = new ArrayList<>();
}
