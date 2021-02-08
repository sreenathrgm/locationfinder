package com.restapi.locationfinder.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket restApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket.apiInfo(apiInfo()).pathMapping("/")
                .select().apis(Predicates.or(RequestHandlerSelectors.withMethodAnnotation(RestController.class)));

        return docket;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Java Restful APIs").version("1.0").build();

    }
}
