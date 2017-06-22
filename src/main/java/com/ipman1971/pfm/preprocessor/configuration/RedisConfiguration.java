package com.ipman1971.pfm.preprocessor.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Ipman1971 on 19/06/2017.
 *
 * Configuracion para Redis a partir de la informacion provista en applicaction-[entorno].yml
 */
@Configuration
@Slf4j
public class RedisConfiguration {

    @Autowired
    private RedisConfigurationProperties redisConfigurationProperties;

    /**
     * Crear la factoria de conexiones a Redis
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory= new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(redisConfigurationProperties.getHost());
        jedisConnectionFactory.setPort(redisConfigurationProperties.getPort());
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
        if(log.isInfoEnabled()) {
            log.info(PfmConstant.ID_LOG+"creada factoria de conexiones Redis en Host: {} - Puerto: {}",jedisConnectionFactory.getHostName(),jedisConnectionFactory.getPort());
        }
        return jedisConnectionFactory;
    }

    /**
     * Configura el pool de conexiones de la factoria Redis, se pueden añadir estos valores al fichero de configuracion mas adelante
     * @return
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisConfigurationProperties.getMaxTotal());
        jedisPoolConfig.setMaxIdle(redisConfigurationProperties.getMaxIdle());
        jedisPoolConfig.setTestOnBorrow(redisConfigurationProperties.isTestOnBorrow());
        if(log.isInfoEnabled()) {
            log.info(PfmConstant.ID_LOG+"creado pool de conexiones Redis: maxTotal: {} - maxIdle: {} - testOnBorrow: {}", new Object[]{
                    redisConfigurationProperties.getMaxTotal(), redisConfigurationProperties.getMaxIdle(), redisConfigurationProperties.isTestOnBorrow()
            });
        }
        return jedisPoolConfig;
    }

}
