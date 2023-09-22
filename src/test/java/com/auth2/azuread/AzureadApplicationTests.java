package com.auth2.azuread;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
@Slf4j
class AzureadApplicationTests {

	@Test
	void contextLoads() {
		Function<Integer,Boolean> isOdd = value ->  value%2==0?false:true;
		Boolean answer = isOdd.apply(1);
		log.info("answer {}" , answer);
	}

}
