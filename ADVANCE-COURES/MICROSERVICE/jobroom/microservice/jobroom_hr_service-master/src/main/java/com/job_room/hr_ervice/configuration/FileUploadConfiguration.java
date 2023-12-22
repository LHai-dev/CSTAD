package com.job_room.hr_ervice.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileUploadConfiguration implements WebMvcConfigurer {

    @Value("${file.upload.client.path}")
    private String client;
    @Value("${file.upload.server.path}")
    private String server;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(client)
                .addResourceLocations("file:"+server);
    }
}
