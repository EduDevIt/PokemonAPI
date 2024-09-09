package com.train.Api;

import com.train.Api.pokemon.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ApiApplicationTests {

	@Test
	void contextLoads() {
		var pokemon = new Pokemon();
		pokemon.setName("asdfger");
		assertEquals("Pikachu",pokemon.getName());
	}

}
