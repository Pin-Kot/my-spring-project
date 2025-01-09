package by.minsk.he.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CardWebDto {
    private UUID cardId;
    private String holderName;
    private String number;
    private BigDecimal amount;
}
