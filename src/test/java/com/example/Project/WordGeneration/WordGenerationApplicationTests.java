package com.example.Project.WordGeneration;

import com.example.Project.WordGeneration.service.WordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WordGenerationApplicationTests {

	@Autowired
	private WordService wordService;

	@Test
	void contextLoads() {
	}

	@Test
	void testGenerateStrings()
	{
		wordService.generateStrings("apple","grapes");
	}
}
