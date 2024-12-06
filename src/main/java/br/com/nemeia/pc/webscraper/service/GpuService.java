package br.com.nemeia.pc.webscraper.service;

import br.com.nemeia.commons.model.Gpu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GpuService {

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendToKafka(Gpu gpu) throws JsonProcessingException {
        kafkaTemplate.send("pc.gpu", mapper.writeValueAsString(gpu));
    }

}
