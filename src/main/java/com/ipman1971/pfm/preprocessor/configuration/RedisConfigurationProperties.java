package com.ipman1971.pfm.preprocessor.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Ipman1971 on 19/06/2017.
 *
 * Clase wrapper de configuracion que posee todos los valores de configuracion respecto al uso de Redis
 */
@Configuration
@ConfigurationProperties("app.redis")
@Getter
@Setter
@ToString
public class RedisConfigurationProperties {

    @NotNull
    private String host;

    @Min(1024)
    private int port;

    @Min(16)
    private int maxIdle;

    @Min(16)
    private int maxTotal;

    @NotNull
    private boolean testOnBorrow;

    @NotNull
    private String inputQueue;

    @NotNull
    private String outputQueue;

}
