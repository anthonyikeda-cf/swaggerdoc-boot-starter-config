package au.org.ikeda.spring.swaggerdoc;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "swaggerdoc")
public class SwaggerConfig {

    private String host;

    private String title;

    private String version;

    private String termsUrl;

    private String description;

    private String licenseUrl;

    private List<String> paths;

    private SwaggerContactConfig swaggerContactConfig;

    public SwaggerConfig(SwaggerContactConfig _contactConfig) {
        this.swaggerContactConfig = _contactConfig;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public SwaggerContactConfig getSwaggerContactConfig() {
        return swaggerContactConfig;
    }

    public void setSwaggerContactConfig(SwaggerContactConfig swaggerContactConfig) {
        this.swaggerContactConfig = swaggerContactConfig;
    }
    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }
}
