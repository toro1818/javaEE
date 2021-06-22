package edu.bjtu.books_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class Swagger2Configuration {
    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "edu.bjtu.books_service.controller";

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("EBookShop-Books-微服务") //设置文档的标题
                .description("EBookShop-Books-微服务 API 接口文档") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
//                .termsOfServiceUrl("http://www.baidu.com") // 设置文档的License信息->1.3 License information
                .contact(new Contact("xxxx","http:localhost:8400/doc.html","xxxx@xxx.com"))
                .build();
    }
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                // 配置api扫描包的一个范围
//                .apis(RequestHandlerSelectors.basePackage("edu.bjtu.books_service.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    /**
//     * 创建文档信息
//     */
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                // 文档标题
//                .title("fqyd api文档")
//                // 版本号
//                .version("1.0")
//                // 描述
//                .description("风轻云淡的api文档")
//                .build();
//    }

}

