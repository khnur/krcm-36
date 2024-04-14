package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.hacknu.krcm36.model.Company;
import lombok.*;

import java.time.LocalDateTime;

public class CashBackDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private Float percent;
        private String condition;
        @JsonProperty("expiry_date")
        private LocalDateTime expiryDate;
        private String restriction;
        @NonNull
        @JsonProperty("bank_card_id")
        private Integer bankCardId;
        @NonNull
        @JsonProperty("company_id")
        private Integer companyId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Integer id;
        private Float percent;
        private String condition;
        @JsonProperty("expiry_date")
        private LocalDateTime expiryDate;
        private String restriction;
        @JsonProperty("bank_card")
        private BankCardDto.Response bankCard;
        private Company company;
    }
}

