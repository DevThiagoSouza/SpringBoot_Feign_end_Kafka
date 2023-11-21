package com.thiago_Souza.Feign_Docker_Kafka.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiago_Souza.Feign_Docker_Kafka.http.EnderecoJson;
import com.thiago_Souza.Feign_Docker_Kafka.response.EnderecoResponse;
import com.thiago_Souza.Feign_Docker_Kafka.service.EnderecoService;
import com.thiago_Souza.Feign_Docker_Kafka.service.ViaCepService;
import jdk.security.jarsigner.JarSignerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("endereco")
public class cepResource {

    private final ViaCepService viaCepService;
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoResponse> obtercep(@PathVariable("cep") String cep){
        EnderecoResponse enderecoResponse = viaCepService.obterCep(cep);
        return ResponseEntity.ok(enderecoResponse);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> enviarEmdereco(@RequestBody EnderecoJson enderecoJson) throws JsonProcessingException {

        log.info("Dados enviados pelo cliente ", enderecoJson);

        EnderecoResponse enderecoResponse = viaCepService.obterCep(enderecoJson.getCep());
        enderecoResponse.setComplemento(enderecoJson.getComplemento());
        enderecoResponse.setNumero(enderecoJson.getNumero());

        ObjectMapper objectMapper = new ObjectMapper();
        String messagem = objectMapper.writeValueAsString(enderecoResponse);

        enderecoService.sendMessage(messagem);
        log.info("Endereco de retornp da api: "  , enderecoResponse);

        return ResponseEntity.ok(enderecoResponse);
    }

}
