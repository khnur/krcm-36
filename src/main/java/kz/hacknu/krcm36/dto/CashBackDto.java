package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.hacknu.krcm36.util.Category;
import lombok.*;

import java.time.LocalDateTime;

public abstract class CashBackDto {
    @JsonProperty
    private Integer id;
    @JsonProperty
    private Category category;
    @JsonProperty
    private Float percent;
    @JsonProperty
    private String condition;
    @JsonProperty("expiry_date")
    private LocalDateTime expiryDate;
    @JsonProperty
    private String restriction;

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request extends CashBackDto {
        @JsonProperty("bank_card_id")
        private Integer bankCardId;
        @JsonProperty("company_id")
        private Integer companyId;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response extends CashBackDto {
        @JsonProperty("bank_card")
        private BankCardDto.Response bankCard;
        private CompanyDto company;
    }
}

