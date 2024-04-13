package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.hacknu.krcm36.util.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CashBackDto {
    private Integer id;
    private BankDto bank;
    private Category category;
    private Float percent;
    private String condition;
    @JsonProperty("expiry_date")
    private LocalDateTime expiryDate;
    private String restriction;
}

