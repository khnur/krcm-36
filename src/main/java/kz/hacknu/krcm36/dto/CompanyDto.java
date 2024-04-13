package kz.hacknu.krcm36.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

public class CompanyDto {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {
        private String name;
        @JsonProperty("photo_url")
        private String photoUrl;
        @JsonProperty("logo_url")
        private String logoUrl;
        @NonNull
        @JsonProperty("category_id")
        private Integer categoryId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Integer id;
        private String name;
        @JsonProperty("photo_url")
        private String photoUrl;
        @JsonProperty("logo_url")
        private String logoUrl;
        private CategoryDto category;
    }
}
