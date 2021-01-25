package com.xxxx.seckill.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/*
 *@program:seckill-demo
 *@author: Tomasonlee
 *@Time: 2021/1/18  11:40
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return  new ApiInfoBuilder().title("我的接口文档")
                .contact(new Contact("Leo","","tomasonl@163.com"))
                .description("这是我的SwaggerUi生成的接口文档")
                .version("1.0.0.0")
                .build();

    }
}


