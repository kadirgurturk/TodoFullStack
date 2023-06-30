package com.kadirgurturk.TodoRestAPI.bean;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModalMapperBean {

    @Bean
    public ModelMapper modalMapper(){
        return new ModelMapper();
    }
}
