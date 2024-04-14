package kz.hacknu.krcm36.adapter;

import kz.hacknu.krcm36.domain.CompanyDetail;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyDetailFactory {
    private final RestTemplate restTemplate = new RestTemplate();
    @Value("${company_detail_url}")
    private String url;

    public List<CompanyDetail> getCompanyDetail(@NonNull String token) {
        ResponseEntity<List<CompanyDetail>> response = restTemplate.exchange(
                url + "?bearer_token={token}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CompanyDetail>>() {
                },
                token
        );

        return Optional.of(response)
                .filter(res -> res.getStatusCode().is2xxSuccessful())
                .map(ResponseEntity::getBody)
                .orElseThrow();
    }
}
