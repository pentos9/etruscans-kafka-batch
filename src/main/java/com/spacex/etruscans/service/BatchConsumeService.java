package com.spacex.etruscans.service;

import com.spacex.etruscans.entity.KafkaMessageRecord;

import java.util.List;

public interface BatchConsumeService {
    void batchConsume(List<KafkaMessageRecord> messageRecords);
}
