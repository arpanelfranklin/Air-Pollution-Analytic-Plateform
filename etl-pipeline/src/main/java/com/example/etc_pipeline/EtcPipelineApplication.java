package com.example.etc_pipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EtcPipelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtcPipelineApplication.class, args);
	}


}
