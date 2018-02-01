package com.jooq.core.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * Documentation plugin version 1.
     *
     * @return
     */
    @Bean
    public Docket swaggerSpringMvcPluginV1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Version 1 Api")
                .select()
                .apis(basePackage("com.jooq.feature.web.v1"))
                .paths(regex("/api/v1.*"))
                .build()
                .enableUrlTemplating(true)
                .apiInfo(apiInfo("1.0"));
    }

    /**
     * Documentation plugin version 2.
     *
     * @return
     */
    @Bean
    public Docket swaggerSpringMvcPluginV2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Version 2 Api")
                .select()
                .apis(basePackage("com.jooq.feature.web.v2"))
                .paths(regex("/api/v2.*"))
                .build()
                .enableUrlTemplating(true)
                .apiInfo(apiInfo("2.0"));
    }

    /**
     * Api info.
     *
     * @param version
     * @return
     */
    private ApiInfo apiInfo(String version) {
        return new ApiInfo("Api documentation", "For demonstration purpose using JOOQ for querying", version, "Terms of Service",
                new Contact("Created by Juan dela Cruz", "http://www.dummy.com", "dummy@domain.com"),
                "License", "http://www.license.com", new ArrayList<>());
    }
}
