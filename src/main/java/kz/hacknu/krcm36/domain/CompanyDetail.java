package kz.hacknu.krcm36.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyDetail {
    private String name;
    @JsonProperty("category_name")
    private String categoryName;
    private String description;
    private Float bonus;
}
