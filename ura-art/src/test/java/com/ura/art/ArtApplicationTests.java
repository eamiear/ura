package com.ura.art;

import com.ura.art.config.DrawerUtils;
import com.ura.art.config.FontUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void getWord() {
		Font font = FontUtils.getFont("AaSaYe-2");
		File file = new File("E:\\userAaSaYe.png");
		try {
			DrawerUtils.createImage("姜育恒", font, file, 100, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
