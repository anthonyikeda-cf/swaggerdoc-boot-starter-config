package au.org.ikeda.spring.swaggerdoc;

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

@EnableConfigurationProperties(SwaggerProperties.class)
@Configuration
@EnableSwagger2
public class SwaggerAutoConfiguration {

    private SwaggerProperties swaggerProperties;

    public SwaggerAutoConfiguration(SwaggerProperties _config) {
        this.swaggerProperties = _config;
    }

    @Bean
    public Docket documentApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        this.swaggerProperties.getPaths().forEach(path -> {
            docket.select().paths(regex(path)).build();
        });

        return docket.protocols(schemes()).host(swaggerProperties.getHost()).apiInfo(metadata());
    }

    private HashSet<String> schemes() {
        HashSet<String> schemes = new HashSet<>();
        schemes.add("http");
        return schemes;
    }

    private ApiInfo metadata() {
        ApiInfoBuilder builder = new ApiInfoBuilder();
        return builder.contact(new Contact(swaggerProperties.getSwaggerContactConfig().getName(),
                swaggerProperties.getSwaggerContactConfig().getUrl(),
                swaggerProperties.getSwaggerContactConfig().getEmail()))
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .termsOfServiceUrl(swaggerProperties.getTermsUrl())
                .license(swaggerProperties.getLicenseUrl()).build();
    }


}
