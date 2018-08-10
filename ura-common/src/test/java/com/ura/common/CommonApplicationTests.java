package com.ura.common;

import com.ura.common.utils.JwtTokenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void generateToken() {
		String token = JwtTokenUtils.generateToken("skz");
		System.out.print("\n\t token ============ " + token + "\n\t");
	}

}
