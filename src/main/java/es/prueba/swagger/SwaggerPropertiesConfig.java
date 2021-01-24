package es.prueba.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import springfox.documentation.service.Contact;

@Component
@ConfigurationProperties("swagger")
@RefreshScope
public class SwaggerPropertiesConfig {

	private String title;
	private String description;
	private String version;
	private String tos;
	private String license;
	private String licenseUrl;
	private Contacto contact = new Contacto();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTos() {
		return tos;
	}

	public void setTos(String tos) {
		this.tos = tos;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getLicenseUrl() {
		return licenseUrl;
	}

	public void setLicenseUrl(String licenseUrl) {
		this.licenseUrl = licenseUrl;
	}

	public Contacto getContact() {
		return contact;
	}

	public void setContact(Contacto contact) {
		this.contact = contact;
	}

	public class Contacto {
		private String name;
		private String url;
		private String email;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Contact getSwaggerContact() {
			return new Contact(this.name, this.url, this.email);
		}
	}
}
