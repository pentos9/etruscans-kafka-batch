package com.spacex.etruscans.service.impl;

import com.spacex.etruscans.entity.KafkaMessageRecord;
import com.spacex.etruscans.service.BatchConsumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchConsumeImpl implements BatchConsumeService {
    private Logger logger = LoggerFactory.getLogger(BatchConsumeImpl.class);

    @Override
    public void batchConsume(List<KafkaMessageRecord> messageRecords) {
        logger.info(String.format("batch consumer starts now ..."));
    }
}
