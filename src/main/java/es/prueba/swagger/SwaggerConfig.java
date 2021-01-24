package es.prueba.swagger;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Autowired
	private SwaggerPropertiesConfig swaggerPropertiesConfig;

	@Autowired
	private ExtendRelativePathProvider extendRelativePathProvider;

	@Value("${spring.application.name}")
	private String applicationName;

	@Autowired
	private Environment environment;

	// private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new
	// HashSet<String>(
	// Arrays.asList("application/json", "application/xml"));
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(swaggerPropertiesConfig.getTitle())
				.description(swaggerPropertiesConfig.getDescription())
				.termsOfServiceUrl(swaggerPropertiesConfig.getTos())
				.contact(swaggerPropertiesConfig.getContact().getSwaggerContact())
				.license(swaggerPropertiesConfig.getLicense()).licenseUrl(swaggerPropertiesConfig.getLicenseUrl())
				.version(swaggerPropertiesConfig.getVersion()).build();
	}

	private ApiKey apiKey() {
		return new ApiKey("apiKey", "Authorization", "header");
	}

	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder().scopeSeparator(",").additionalQueryStringParams(null)
				.useBasicAuthenticationWithAccessCodeGrant(false).build();
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("apiKey", authorizationScopes));
	}

	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @return the environment
	 */
	public Environment getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
}

