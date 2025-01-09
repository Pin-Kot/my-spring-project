package by.minsk.he.models;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CardModel {
    private UUID cardId;
    private String holderName;
    private String number;
    private BigDecimal amount;
}
