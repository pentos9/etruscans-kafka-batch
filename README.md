# etruscans-kafka-batch

## useful commands: some of my favorite commands

```

kafka broker address:127.0.0.1:9092

zookeeper address:127.0.0.1:2181

topic:test-topic
```

* #### describe topic (查看某个topic 的信息)
    bash kafka-topics.sh --zookeeper 127.0.0.1:2181 --topic test-topic --describe

* #### kafka consumer data (kafka消费消息的情况)
    bash kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --from-beginning --topic test-topic

* #### topic consumer offset (查看topic消费到的offset)
    bash kafka-run-class.sh kafka.tools.GetOffsetShell --broker-list 127.0.0.1:9092 --topic test-topic --time -1

* #### kafka-consumer-groups partition和consumer relationship (查看partition和消费者进程对应关系如下)
    bash kafka-consumer-groups.sh --bootstrap-server 127.0.0.1:9092 --describe --group test-workers

* #### modify partition of topic（only increase and no decrease） (修改topic的partition数量（只能增加不能减少）)
    bash kafka-topics.sh --alter --zookeeper 127.0.0.1:2181 --partitions 2 --topic test-topic