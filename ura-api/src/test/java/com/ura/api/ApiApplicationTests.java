package com.ura.api;

import com.ura.common.utils.HttpClientUtils;
import org.apache.http.conn.ConnectTimeoutException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.SocketTimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void HttpClientTest() {
		try {
			String str = HttpClientUtils.get("http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%93%B6%E9%AD%82&bk_length=600");
			System.out.println("weather  === " + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
