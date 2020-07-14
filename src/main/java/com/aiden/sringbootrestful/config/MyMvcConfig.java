package com.aiden.sringbootrestful.config;

import com.aiden.sringbootrestful.component.LoginHandlerInterceptor;
import com.aiden.sringbootrestful.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*WebMvcConfigurationSupport会访问不到静态资源*/
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                //设置拦截的请求
                .addPathPatterns("/**")
                //不过拦截器的请求
                .excludePathPatterns("/index.html"
                        , "/"
                        , "/user/login"
                        , "/webjars/**"  //不拦截静态请求
                        , "/asserts/**");
    }
}
