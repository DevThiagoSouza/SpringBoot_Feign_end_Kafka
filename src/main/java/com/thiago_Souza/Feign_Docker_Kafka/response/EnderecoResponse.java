package com.thiago_Souza.Feign_Docker_Kafka.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnderecoResponse {

    private String cep;
    private String logadouro;
    private String complemento;
    private String bairro;
    private String uf;
    private Long numero;
}
