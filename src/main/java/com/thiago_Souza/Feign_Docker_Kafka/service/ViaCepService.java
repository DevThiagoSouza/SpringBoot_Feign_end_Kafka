package com.thiago_Souza.Feign_Docker_Kafka.service;

import com.thiago_Souza.Feign_Docker_Kafka.response.EnderecoResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json")
    EnderecoResponse obterCep(@PathVariable("cep") String cep);
}
