package com.spacex.etruscans.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class KafkaMessageRecord implements Serializable {
    private Long id;
    private String name;
}
