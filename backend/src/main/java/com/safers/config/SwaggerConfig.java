package com.safers.config;

import io.swagger.models.parameters.Parameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.image.renderable.ParameterBlock;

import static com.google.common.collect.Lists.newArrayList;

/**
 * API 문서 관련 swagger2 설정 정의.
 * 주소: https://localhost:8080/swagger-ui/
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        /* Authorization 헤더를 위한 설정 */
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        parameterBuilder
                .name("Authorization")
                .description("AccessToken")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();

        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .supportedSubmitMethods(newArrayList("get").toArray(new String[0])) // try it 기능 활성화 범위
                .build();
    }
}