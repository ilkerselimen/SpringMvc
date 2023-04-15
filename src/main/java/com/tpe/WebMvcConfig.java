package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("com.tpe") // optional
@EnableWebMvc // MVC icin config etkinlestirmek icin
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean// view name e karsilik gelen view dosyasinin cozumlenmesini: viewResolver
    public InternalResourceViewResolver resolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class); // JavaStandardTagLibrary: JSP dosyalari icinde daha az kod yazmamizi saglar.
        resolver.setPrefix("/WEB-INF/views/"); // view dosyalari nerede ? (dizin)
        resolver.setSuffix(".jsp"); // view dosyalarinin uzantisi
        return resolver();
    }

    // css, image static olan kaynaklarin dispatchera gonderilmesine gerek yok

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**"). // bu pathdeki kaynaklari static olarak sun.
                 addResourceLocations("/resources/"). // kaynaklarin yeri
                 setCachePeriod(0); // cacheleme icin belirli bir period suresi verilebilir.
    }


}
