package com.snsoft.configs;

import com.snsoft.comn.TestConstant;
import com.snsoft.utils.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        ParameterBuilder userPar = new ParameterBuilder();
        List<Parameter> pars = addTokenHeader(tokenPar, userPar);
        return new Docket(DocumentationType.SWAGGER_2)
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.basePackage("com.snsoft.controllers")) // 对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }

    private List<Parameter> addTokenHeader(ParameterBuilder tokenPar, ParameterBuilder userPar) {
        List<Parameter> pars = new ArrayList<>();
        userPar.name("visitor")
                .description("访问者")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .defaultValue(TestConstant.TEST_USER_ID);
        tokenPar.name("x-access-token")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .defaultValue(JwtUtil.getToken(TestConstant.TEST_USER_ID));
        pars.add(tokenPar.build());
        pars.add(userPar.build());
        return pars;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("")
                .description("后台服务")
//                .license("Apache 2.0")
//                .licenseUrl("http://www.rgsc.com")
                .version("1.0")
                .contact(new Contact("Jack", "", "zhuye0213@126.com"))
                .build();
    }
}
