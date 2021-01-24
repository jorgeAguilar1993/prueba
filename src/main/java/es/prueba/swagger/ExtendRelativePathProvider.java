package es.prueba.swagger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;

@Component
public class ExtendRelativePathProvider extends AbstractPathProvider {

	@Value("${spring.application.name}")
	private String applicationName;

	private String basePath;

	@PostConstruct
	public void init() {
		this.basePath = "/" + applicationName;
	}

	@Override
	protected String applicationPath() {
		return "/";
	}

	@Override
	public String getOperationPath(String operationPath) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(basePath);
		return Paths.removeAdjacentForwardSlashes(
				uriComponentsBuilder.path(operationPath.replaceFirst(basePath, "")).build().toString());
	}

	@Override
	protected String getDocumentationPath() {
		return "/";
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
}
