package com.ura.art;

import com.ura.art.config.DrawerUtils;
import com.ura.art.config.FontUtils;
import com.ura.common.utils.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void getWord() {
		Font font = FontUtils.getFont("signature");
		File file = new File("E:\\signature.png");
		try {
			DrawerUtils.createImage("姜育恒", font, file, 100, 100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void getContentFormUrl() {
	  String base = "http://www.jiqie.com/a/re14.php";
		String url = "http://www.yishuzi.com/b/re13.php";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", "周杰伦");
		params.put("idi", "jiqie");
		params.put("id1", "901");
		params.put("id2", "#FFFFFF");
		params.put("id4", "#FFFFFF");
    params.put("id6", "#000000");
		String content = HttpUtil.URLPost(url, params, true);
		System.out.println("content   =====  " + content);
	}
}
