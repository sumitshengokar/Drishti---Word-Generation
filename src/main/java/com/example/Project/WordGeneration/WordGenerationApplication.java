package com.example.Project.WordGeneration;

import com.example.Project.WordGeneration.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

//Looks like the initial problem is with the auto-config.
//If you don't need the datasource, simply remove it from the auto-config process:
//As we have not created any model , so there is no data source
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class WordGenerationApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(WordGenerationApplication.class, args);
		WordService ws=context.getBean(WordService.class);
		ws.readJson();

	}

}
