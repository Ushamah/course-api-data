package io.javabrains.ushwamala.courseapidata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.javabrains"))
                .build().apiInfo(apiDetails());
    }


    private ApiInfo apiDetails(){
        return new ApiInfo(
                "Course-Topic-API",
                "A sample API for demonstrating the use of Swagger-API",
                "1.0.0",
                "Free to use",
                new Contact("Ushamah Wamala","https://github.com/Ushamah","ushwamala@gmail.com"),
                "API License",
                "https://github.com/Ushamah",
                Collections.emptyList()
        );
    }
}
