package au.org.ikeda.spring.swaggerdoc;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableConfigurationProperties(SwaggerConfig.class)
@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration {

    private SwaggerConfig swaggerConfig;

    public SwaggerAutoConfiguration(SwaggerConfig _config) {
        this.swaggerConfig = _config;
    }

    @Bean
    public Docket documentApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        this.swaggerConfig.getPaths().forEach(path -> {
            docket.select().paths(regex(path)).build();
        });

        return docket.protocols(schemes()).host(swaggerConfig.getHost()).apiInfo(metadata());
    }

    private HashSet<String> schemes() {
        HashSet<String> schemes = new HashSet<>();
        schemes.add("http");
        return schemes;
    }

    private ApiInfo metadata() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        return builder.contact(new Contact(swaggerConfig.getSwaggerContactConfig().getName(),
                swaggerConfig.getSwaggerContactConfig().getUrl(),
                swaggerConfig.getSwaggerContactConfig().getEmail()))
                .title(swaggerConfig.getTitle())
                .description(swaggerConfig.getDescription())
                .version(swaggerConfig.getVersion())
                .termsOfServiceUrl(swaggerConfig.getTermsUrl())
                .license(swaggerConfig.getLicenseUrl()).build();
    }


}
