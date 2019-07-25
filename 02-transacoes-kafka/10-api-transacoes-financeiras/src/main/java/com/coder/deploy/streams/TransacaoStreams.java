package com.coder.deploy.streams;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TransacaoStreams {

    String OUTPUT = "kafka-send-out";
    
    @Output(OUTPUT)
    MessageChannel notifyTo();
}
