package br.edu.infnet.lojavirtual;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.edu.infnet.lojavirtual.controller"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(apiInfo());
		
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
		.title("API REST - Inventario de produtos")
		.description("Mantem o estoque e preco dos produtos")
		.version("1.0.0")
		.license("Apache License Version 2.0")
		.licenseUrl("https://www.apache.org/licences")
		.contact(new Contact("danfmsouza", "https://github.com/danfmsouza", "kaedesm@gmail.com"))
		.build();
	}
	
	
}
