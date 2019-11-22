package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * swagger-ui配置(生成环境禁用)
 *
 * @author zhou
 * @date 2019-04-01 16:04
 * @since JDK1.8
 */
@Configuration
@EnableSwagger2
@Primary
public class Swagger2Config implements SwaggerResourcesProvider {
    private static final String SWAGGER_SCAN_BASE_PACKAGE = "com.example";

    @Bean
    public Docket createRestApi() {
        Set<String> protocols = new HashSet<>();
        protocols.add("http");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .protocols(protocols)
                .securitySchemes(this.securitySchemes())
                .securityContexts(this.securityContexts())
                .apiInfo(this.apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("example API")
                .description("example接口详细说明")
                .contact(new Contact("example", "", "example@126.com"))
                .version("1,0,0")
                .build();
    }


    private List<ApiKey> securitySchemes() {
        List<ApiKey> list = new ArrayList<>();
        list.add(new ApiKey("Authorization", "Authorization", "header"));
        return list;
    }


    private List<SecurityContext> securityContexts() {
        List<SecurityContext> list = new ArrayList<>();
        list.add(SecurityContext.builder()
                .securityReferences(this.defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build());
        return list;
    }


    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> list = new ArrayList<>();
        list.add(new SecurityReference("Authorization", authorizationScopes));
        return list;
    }


    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource());
        return resources;
    }


    private SwaggerResource swaggerResource() {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName("example");
        swaggerResource.setLocation("/v2/api-docs");
        swaggerResource.setSwaggerVersion("1.0.0");
        return swaggerResource;
    }

}
