package com.jiao.chatonlineserver.configs;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
//@ EnableSwagger2支持Swagger 2的SpringFox支持
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SpringFoxConfig {
    @Bean
    public Docket apiDocket(){
        //规范2标准
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //有时，缩小类，SpringFox会将其检测为文档生成源。Controller和Model类。您可以在Docket配置中轻松配置它。还记得像我们使用.apis（RequestHandlerSelectors.any（）来包含所有类吗？让我们将它缩小到我们的基础包：
                .apis(RequestHandlerSelectors.basePackage("com.jiao.chatonlineserver"))
                //.paths（PathSelectors.any（））？您可以将其限制为某些正则表达式或Ant样式的路径模式，而不是匹配所有路径的任何路径。
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.getApiInfo());
    }
    /*
    * 。在SpringFoxConfiguration文件中，我们需要添加ApiInfo对象，该对象提供有关API的一般信息，例如标题，版本，联系人或许可信息*/
    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "TITLE",
                "DESCIPRION",
                "VERSION_1.0",
                "TERMS OF SERVICE URL",
                new Contact("jiao","URL","2935996123@qq.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}
