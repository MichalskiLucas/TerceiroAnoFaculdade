package br.com.unipar.Hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HospitalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(geraInfoSwagger())
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.unipar.Hospital"))
				.paths(PathSelectors.any())
				.build();
	}

	public ApiInfo geraInfoSwagger() {
		return new ApiInfo("Trabalho em Spring Boot - Hospital",
				"Sistema Criado para o trabalho da materia de desenvolvimento de aplicações para web",
				"1.0", null, "Lucas Michalski e Kedssy Luan", null, null);
	}
}
