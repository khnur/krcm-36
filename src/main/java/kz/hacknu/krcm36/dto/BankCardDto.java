package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.hacknu.krcm36.util.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankCardDto {
    private Integer id;
    private BankDto bank;
    private CardType type;
    @JsonProperty("card_number")
    private String cardNumber;
    @JsonProperty("expiry_date")
    private LocalDate expiryDate;
    private UserDto user;
}
