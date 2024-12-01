package br.com.nemeia.pc.webscraper.service;

import org.springframework.kafka.annotation.KafkaListener;

@KafkaListener(topics = "pc.gpu", groupId = "foo")
public class ListenerService {

    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }

}
