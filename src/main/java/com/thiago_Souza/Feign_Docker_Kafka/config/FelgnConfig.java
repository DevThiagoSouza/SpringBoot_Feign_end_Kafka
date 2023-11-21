package com.thiago_Souza.Feign_Docker_Kafka.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FelgnConfig {

    @Value("${api.cep.username}")
    private String usuario;

    @Value("${api.cep.senha}")
    private String senha;

    private BasicAuthRequestInterceptor basicAuthRequestInterceptor;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor(usuario, senha);
    }

}
