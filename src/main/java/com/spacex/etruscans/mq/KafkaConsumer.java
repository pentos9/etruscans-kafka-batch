package com.spacex.etruscans.mq;

import com.spacex.etruscans.entity.KafkaMessageRecord;
import com.spacex.etruscans.service.BatchConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Component
public class KafkaConsumer {
    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @Resource
    private BatchConsumeService batchConsumeService;

    @KafkaListener(topics = "${kafka.consumer.topicName}", containerFactory = "batchFactory")
    public void listen(List<KafkaMessageRecord> messageRecords) {
        logger.info(String.format("KafkaConsumer#listen messageRecords:%s", messageRecords));
        doBatchConsume(messageRecords);
    }

    public void doBatchConsume(List<KafkaMessageRecord> messageRecords) {
        if (messageRecords == null || messageRecords.isEmpty()) {
            return;
        }

        batchConsumeService.batchConsume(messageRecords);
    }


    @KafkaListener(topics = "${kafka.consumer.single.topicName}")
    public void doListen(KafkaMessageRecord messageRecord) {
        logger.info(String.format("messageRecord:%s", messageRecord));
        doConsume(messageRecord);
    }

    public void doConsume(KafkaMessageRecord messageRecord) {
        if (messageRecord == null) {
            return;
        }

        batchConsumeService.batchConsume(Arrays.asList(messageRecord));
    }
}
