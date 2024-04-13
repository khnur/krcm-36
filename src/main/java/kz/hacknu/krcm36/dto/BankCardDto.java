package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    @JsonProperty(value = "bank_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer bankId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BankDto bank;
    private CardType type;
    @JsonProperty("card_number")
    private String cardNumber;
    @JsonProperty("expiry_date")
    private LocalDate expiryDate;
    @NotNull
    @JsonProperty(value = "user_id", access = JsonProperty.Access.WRITE_ONLY)
    private Integer userId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UserDto user;
}
