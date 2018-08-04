package com.ura.generator;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void textFastJson() {
		Object object = (Object)1;
		System.out.print("===================  " + JSON.toJSONString(object));
	}

}
