package kz.hacknu.krcm36.dto;

import kz.hacknu.krcm36.util.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyDto {
    private Integer id;
    private String name;
    private Category category;
}
