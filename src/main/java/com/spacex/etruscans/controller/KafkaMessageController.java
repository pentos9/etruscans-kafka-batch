package com.spacex.etruscans.controller;

import com.spacex.etruscans.entity.KafkaMessageRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

@RestController
public class KafkaMessageController {

    @Value("${kafka.consumer.topicName:test}")
    private String topic;

    @Resource
    private KafkaTemplate<String, KafkaMessageRecord> kafkaTemplate;

    @RequestMapping(value = "kafka/produce", method = RequestMethod.POST)
    public String kafkaProducer() {

        for (int i = 0; i < 10; i++) {
            KafkaMessageRecord messageRecord = new KafkaMessageRecord();
            messageRecord.setId(System.currentTimeMillis() + ":" + new Random().nextLong());
            messageRecord.setName("sample:" + UUID.randomUUID().toString());
            kafkaTemplate.send(topic, messageRecord);
        }
        return "OK";
    }
}
