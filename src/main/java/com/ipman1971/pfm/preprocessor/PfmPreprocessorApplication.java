package com.ipman1971.pfm.preprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@ComponentScan("com.ipman1971.pfm.preprocessor")
@EnableIntegration
@IntegrationComponentScan("com.ipman1971.pfm.preprocessor.integration")
@ImportResource("classpath:META-INF/pfm-context-base.xml")
public class PfmPreprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfmPreprocessorApplication.class, args);
	}

}
