package com.ipman1971.pfm.preprocessor.integration;

import com.ipman1971.pfm.preprocessor.configuration.RedisConfiguration;
import com.ipman1971.pfm.preprocessor.configuration.RedisConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Ipman1971 on 16/06/2017.
 */
@Configuration
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

    /**
     * Crea un DirectChannel general de entrada de peticiones para la cola redis
     *
     * @return
     */
    @Bean
    public MessageChannel pfmRequestChannel() {
        return new DirectChannel();
    }

    /**
     * Crea un DirecChannel general de salida a cola Redis
     * @return
     */
    @Bean
    public MessageChannel pfmOutputChannel() {
        return new DirectChannel();
    }

    /**
     * Crea un DirecChannel general de salida a cola Redis
     * @return
     */
    @Bean
    public MessageChannel pfmErrorChannel() {
        return new DirectChannel();
    }

}
