package kz.hacknu.krcm36.dto;

import kz.hacknu.krcm36.util.ServiceCategory;
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
    private ServiceCategory category;
}
