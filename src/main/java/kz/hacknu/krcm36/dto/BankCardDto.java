package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import kz.hacknu.krcm36.util.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class BankCardDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Integer id;
        private CardType type;
        @JsonProperty("card_number")
        private String cardNumber;
        @JsonProperty("expiry_date")
        private LocalDate expiryDate;
        @NotNull
        @JsonProperty(value = "bank_id")
        private Integer bankId;
        @NotNull
        @JsonProperty(value = "user_id")
        private Integer userId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Integer id;
        private CardType type;
        @JsonProperty("card_number")
        private String cardNumber;
        @JsonProperty("expiry_date")
        private LocalDate expiryDate;
        private BankDto bank;
        private UserDto user;
    }
}
