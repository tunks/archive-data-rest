package com.att.archive.restful.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

/**
 *
 * @author ebrima
 */

@SpringBootApplication
@ImportResource("spring-config.xml")
public class Application { //extends WebMvcConfigurerAdapter
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
//     @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        UrlPathHelper urlPathHelper = new UrlPathHelper();
//        urlPathHelper.setUrlDecode(true);
//        configurer.setUrlPathHelper(urlPathHelper);
//    }
}