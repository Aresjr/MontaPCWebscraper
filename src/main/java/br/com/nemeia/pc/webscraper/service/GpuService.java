package br.com.nemeia.pc.webscraper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GpuService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendToKafka(JSONObject gpuModel) {
        //TODO - implement
        kafkaTemplate.send("pc.gpu", gpuModel.toString());
    }

}
