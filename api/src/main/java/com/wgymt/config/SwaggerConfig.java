package com.wgymt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * swagger 会自动生成接口文档
     * 1: 配置生成的文档信息
     * 2: 配置生成规则
     */

    /*Docket 封装接口信息*/
    @Bean
    public Docket getDocket() {
        // 指定文档风格
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        ApiInfo apiInfo = apiInfoBuilder.title("fmmall后端接口说明")
                .description("此文档详细说明了项目后端接口规范.")
                .version("2.0.1")
                .contact(new Contact("Kenja",
                        "https://www.wgymt.com",
                        "yagamelai@gmail.com"))
                .build();

        // 指定生成的文档中的封面信息: 文档标题, 版本, 作者
        docket.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wgymt.controller"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
