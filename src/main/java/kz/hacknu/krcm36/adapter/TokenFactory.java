package kz.hacknu.krcm36.adapter;

import kz.hacknu.krcm36.domain.BearerToken;
import kz.hacknu.krcm36.domain.CompanyDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenFactory {
    private final RestTemplate tokenRestTemplate = new RestTemplate();
    private final RestTemplate scrapeRestTemplate = new RestTemplate();

    public String createToken() {
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("scope", "sms_send");
        formData.add("client_id", "halykbankkz");
        formData.add("client_secret", "bCI7YdlOzC2h7LAgaZJJQArqhPpYQIIPtdXgdbi4zNqMVz1cVaVOyka2eTmlqSBH");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        BearerToken bearerToken = tokenRestTemplate.postForObject("https://oauth.homebank.kz/oauth2/token", requestEntity, BearerToken.class);

        return Optional.ofNullable(bearerToken)
                .map(BearerToken::getAccessToken)
                .orElseThrow();
    }

    public CompanyDetail getCompanyDetail(String token) {

        return null;
    }
}
