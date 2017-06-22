package com.ipman1971.pfm.preprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@ComponentScan("com.ipman1971.pfm.preprocessor")
@EnableIntegration
@IntegrationComponentScan("com.ipman1971.pfm.preprocessor.integration")
public class PfmPreprocessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfmPreprocessorApplication.class, args);
	}

}
