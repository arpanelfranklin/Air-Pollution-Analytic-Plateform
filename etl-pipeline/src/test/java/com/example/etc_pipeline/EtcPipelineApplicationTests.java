package com.example.etc_pipeline;

import com.example.etc_pipeline.entity.PollutionData;
import com.example.etc_pipeline.repository.PollutionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EtcPipelineApplicationTests {

	@Autowired
	private PollutionRepository pollutionRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void addData(){
		PollutionData pollutionData = new PollutionData();
		pollutionData.setCountry("India");
		pollutionData.setCity("Delhi");
		pollutionData.setAqiValue(400);
		pollutionRepository.save(pollutionData);
	}

}
