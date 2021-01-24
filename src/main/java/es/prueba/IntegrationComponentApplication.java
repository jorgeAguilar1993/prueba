package es.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Clase encargada de gestionar el arranque del microservicio para gestionar las entidades.
 */
@EnableSwagger2
@EnableTransactionManagement
@SpringBootApplication
@EnableFeignClients(basePackages = {  "es.prueba.client" })
@ComponentScan({  "es.prueba" })
public class IntegrationComponentApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationComponentApplication.class, args);
	}

}
