package com.safers.config;


import com.safers.common.handler.KakaoAuthenticationHandler;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3000);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);

        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/WEB-INF/resources/");
    		
        registry.addResourceHandler("/swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    		
        /*
    	 *
    	 * Front-end에서 참조하는 URL을 /dist로 매핑
    	 *
    	 */
        registry.addResourceHandler("/css/**")
                .addResourceLocations("classpath:/dist/css/");
        registry.addResourceHandler("/fonts/**")
                .addResourceLocations("classpath:/dist/fonts/");
        registry.addResourceHandler("/icons/**")
				.addResourceLocations("classpath:/dist/icons/");
        registry.addResourceHandler("/img/**")
			    .addResourceLocations("classpath:/dist/img/");
        registry.addResourceHandler("/js/**")
				.addResourceLocations("classpath:/dist/js/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new KakaoAuthenticationHandler())
               .excludePathPatterns("/**")

               .addPathPatterns("/api") // api 관련 Patterns
               .excludePathPatterns("/api/user/login")
               .excludePathPatterns("/api/user/token")
               .excludePathPatterns("/api/user/token/refresh")
               .excludePathPatterns("/api/unity");
    }
}
