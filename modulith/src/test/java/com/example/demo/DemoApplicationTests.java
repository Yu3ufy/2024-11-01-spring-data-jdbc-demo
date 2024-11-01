package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		
		var am  = ApplicationModules.of(DemoApplication.class);
		am.verify();

		System.out.println(am);
		
		new Documenter(am).writeDocumentation();
		
	}

}