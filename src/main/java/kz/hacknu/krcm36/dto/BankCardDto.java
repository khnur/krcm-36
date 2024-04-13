package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import kz.hacknu.krcm36.util.CardType;
import lombok.*;

import java.time.LocalDate;

public abstract class BankCardDto {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private CardType type;
    @JsonProperty("card_number")
    private String cardNumber;
    @JsonProperty("expiry_date")
    private LocalDate expiryDate;

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request extends BankCardDto {
        @NotNull
        @JsonProperty(value = "bank_id")
        private Integer bankId;
        @NotNull
        @JsonProperty(value = "user_id")
        private Integer userId;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response extends BankCardDto {
        private BankDto bank;
        private UserDto user;
    }
}
