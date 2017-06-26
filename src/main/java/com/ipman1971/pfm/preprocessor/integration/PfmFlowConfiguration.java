package com.ipman1971.pfm.preprocessor.integration;

import com.ipman1971.pfm.preprocessor.configuration.RedisConfiguration;
import com.ipman1971.pfm.preprocessor.configuration.RedisConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;
import org.springframework.messaging.MessageChannel;

import java.io.UnsupportedEncodingException;

/**
 * Created by Ipman1971 on 16/06/2017.
 */
@Configuration
@Slf4j
public class PfmFlowConfiguration {

    @Autowired
    private RedisConfigurationProperties redisConfigurationProperties;

    @Autowired
    private RedisConfiguration redisConfiguration;

    @Bean
    public RedisQueueMessageDrivenEndpoint pfmQueueInboundChannelAdapter() {
        RedisQueueMessageDrivenEndpoint redisQueueMessageDrivenEndpoint=new RedisQueueMessageDrivenEndpoint(
                redisConfigurationProperties.getInputQueue(),redisConfiguration.jedisConnectionFactory());
        redisQueueMessageDrivenEndpoint.setErrorChannel(pfmErrorChannel());
        redisQueueMessageDrivenEndpoint.setOutputChannel(pfmRequestChannel());
        redisQueueMessageDrivenEndpoint.setRightPop(true); //FIFO queue
        return redisQueueMessageDrivenEndpoint;
    }

    @Transformer(inputChannel = "pfmRequestChannel", outputChannel = "pfmOutputChannel")
    public String transformBean(final byte[] input) {
        try {
            log.info("input " + new String(input, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            log.error("encoding doesnt supported");
        }
        return "";
    }

    /**
     * Crea un DirectChannel general de entrada de peticiones para la cola redis
     *
     * @return
     */
    @Bean(name="pfmRequestChannel")
    public MessageChannel pfmRequestChannel() {
        return new DirectChannel();
    }

    /**
     * Crea un DirecChannel general de salida a cola Redis
     * @return
     */
    @Bean(name="pfmOutputChannel")
    public MessageChannel pfmOutputChannel() {
        return new DirectChannel();
    }

    /**
     * Crea un DirecChannel general de salida a cola Redis
     * @return
     */
    @Bean(name="pfmErrorChannel")
    public MessageChannel pfmErrorChannel() {
        return new DirectChannel();
    }

}
