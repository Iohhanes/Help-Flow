package com.helpflow.core.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.helpflow.core.controller")
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(byteArrayHttpMessageConverter());
    }

    private ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
        ByteArrayHttpMessageConverter byteArrayHttpMessageConverter =
                new ByteArrayHttpMessageConverter();
        byteArrayHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes());
        return byteArrayHttpMessageConverter;
    }

    private List<MediaType> supportedMediaTypes() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.IMAGE_PNG);
        mediaTypes.add(MediaType.IMAGE_JPEG);
        return Collections.unmodifiableList(mediaTypes);
    }
}
