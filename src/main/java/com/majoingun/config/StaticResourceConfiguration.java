package com.majoingun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 */
@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
    private static final String [] CLASSPATH_RESOURCE_LOCATIONS = {"classpath:/static/", "classpath:/public/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/majoingun/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
                .setCachePeriod(3600);
    }
}
