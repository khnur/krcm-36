package kz.hacknu.krcm36;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.time.Duration;

@OpenAPIDefinition(
        info = @Info(
                title = "KRCM-36",
                version = "1.0.0",
                description = "not the worst team",
                termsOfService = "termOfService",
                contact = @Contact(
                        name = "Nurzhan",
                        email = "nurzhan.kozhamuratov@nu.edu.kz"
                ),
                license = @License(
                        name = "team3license"
                )
        )
)
@Configuration
public class Config {
    @Value("aaaaaa")
    private String url;

    @Bean
    public RestTemplate webScraper() {
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//        factory.setReadTimeout(getReadTimeout() * 1000);
//        factory.setConnectTimeout(getConnectTimeout() * 1000);
//        factory.setConnectionRequestTimeout(getConnectTimeout() * 1000);
//        factory.setHttpClient(HttpClientBuilder
//                .create()
//                .disableCookieManagement()      // disabled restTemplate to store cookies
//                .setMaxConnTotal(100)
//                .setMaxConnPerRoute(50)
//                .build());
//
//        BufferingClientHttpRequestFactory bufferingClientHttpRequestFactory = new BufferingClientHttpRequestFactory(factory);

        return new RestTemplateBuilder()
                .uriTemplateHandler(new DefaultUriBuilderFactory(url))
                .setReadTimeout(Duration.ofMinutes(6))
                .build();
    }

    public static ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setPropertyCondition(Conditions.isNotNull());
        return mapper;
    }
}
