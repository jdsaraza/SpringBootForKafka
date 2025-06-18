package com.kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    public NewTopic generateTopic(){

        Map<String, String> configurations = new HashMap<>();
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);//DELETE(BORRA), COMPACT(CONSERVA ACTUAL)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "300000");//TIEMPO DE RETENCIÓN MSG(EN MILLIS)
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "10485760");//TAMAÑO MÁXIMO DEL SEGMENTO(BYTES)
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "10485760");//TAMAÑO MÁXIMO CADA MSG(BYTES)

        return TopicBuilder.name("test-Topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
