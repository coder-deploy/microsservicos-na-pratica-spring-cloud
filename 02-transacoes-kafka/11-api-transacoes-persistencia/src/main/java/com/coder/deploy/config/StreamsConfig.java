package com.coder.deploy.config;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.coder.deploy.streams.TransacaoStreams;

@EnableBinding(TransacaoStreams.class)
public class StreamsConfig {

}
