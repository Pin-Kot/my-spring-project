package by.minsk.he.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UserDto {
    private UUID userId;
    private String login;
    private String password;
    private String nickname;
    private String mobilePhone;
    private String email;
    private BigDecimal balance;
    private List<UUID> favoritesAdvertisementId;
}
