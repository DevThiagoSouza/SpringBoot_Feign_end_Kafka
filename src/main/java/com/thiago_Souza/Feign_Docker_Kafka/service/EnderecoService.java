package com.thiago_Souza.Feign_Docker_Kafka.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class EnderecoService {

    @Value("${topic.endereco-cliente}")
    private String topicEnderecoCliente;
    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;

    public void sendMessage(String message){
        this.KafkaTemplate.send(topicEnderecoCliente, message);
        log.info("Messagem enviada para o topic.endereco-cliente" , message);
    }


}
