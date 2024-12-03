package by.misk.he.stubs;

import by.minsk.he.models.UserModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserStubs {

    public static final UUID USER_ID = UUID.fromString("8e7d5f63-b1c5-4c7d-9ec1-9796f6a3b4c0");
    public static final String LOGIN = "Alice";
    public static final String PASSWORD = "ENIGMA";
    public static final String NICKNAME = "Scarlet";
    public static final String MOBILE_PHONE = "+375297777777";
    public static final BigDecimal BALANCE = BigDecimal.valueOf(10);
    public static final List<UUID> FAVORITES = new ArrayList<>();

    public UserModel createUserStubs() {
        return UserModel.builder()
                .login(LOGIN)
                .password(PASSWORD)
                .nickname(NICKNAME)
                .mobilePhone(MOBILE_PHONE)
                .balance(BALANCE)
                .favoritesAdvertisementId(FAVORITES)
                .build();
    }
}
