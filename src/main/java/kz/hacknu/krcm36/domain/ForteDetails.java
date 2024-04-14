package kz.hacknu.krcm36.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForteDetails {
    private Float cashback;
    private String category;
    private String name;
}
