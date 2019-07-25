package com.coder.deploy.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TransacaoStreams {

	String INPUT = "kafka-send-in";
    String OUTPUT = "kafka-send-out";
    
    @Input(INPUT)
    SubscribableChannel subscribe();
    
    @Output(OUTPUT)
    MessageChannel notifyTo();
}
