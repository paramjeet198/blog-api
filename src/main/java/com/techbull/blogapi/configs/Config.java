package com.techbull.blogapi.configs;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()

                .setSkipNullEnabled(false);
        return modelMapper;
    }
}
