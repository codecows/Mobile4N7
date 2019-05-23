package com.snsoft.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CustomerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/users/login/**")
                .excludePathPatterns("/error/**")
                .excludePathPatterns("/swagger-resources/**");
        super.addInterceptors(registry);
    }

}
