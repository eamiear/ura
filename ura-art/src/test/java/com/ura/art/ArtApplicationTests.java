package com.ura.art;

import com.ura.art.config.DrawerUtils;
import com.ura.art.config.FontUtils;
import com.ura.common.utils.HttpUtil;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtApplicationTests {

//  @Autowired
//  private ArtService artService;


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

	@Test
	public void createSignature() {
//    artService.createSignatureImageViaThirdServer();
  }

	@Test
	// 下载网络图片
	public void getImage() {
		GetMethod getMethod = null;
		try {
			String imageUrl = "http://www.yishuzi.com/i/78/1124.gif";
			Map<String, String> param = new HashMap<String, String>();
			param.put("t", String.valueOf(new Date().getTime()));
//			System.out.println("===========   " + HttpUtil.URLGet(imageUrl, param, "utf-8"));
			System.out.println("===========   " + HttpUtil.URLGet(imageUrl, param));
//			InputStream stream = HttpUtil.URLGet(imageUrl, param);
			getMethod = HttpUtil.URLGet(imageUrl, param);
			if (getMethod == null) return;
			InputStream stream = getMethod.getResponseBodyAsStream();
//			ImageIO.write(stream, "png", new File("F:\\cut.png"));
			FileOutputStream fileOut = new FileOutputStream("F:\\cut.png");
			BufferedOutputStream bos = new BufferedOutputStream(fileOut);

			byte[] buf = new byte[4096];
			int length = stream.read(buf);
			//保存文件
			while(length != -1) {
				bos.write(buf, 0, length);
				length = stream.read(buf);
			}
//			DrawerUtils.cutImage(stream, "F:\\cut.git", 0, 40, 500,211);
			bos.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
				getMethod = null;
			}
		}
	}
	@Test
	// 图片裁剪
	public void cutImage(){
		String imageUrl = "http://www.yishuzi.com/i/78/1124.gif";
		String imageUrl1 = "http://www.yishuzi.com/i/78/1124.gif";
		try{
//			DrawerUtils.cutRemoteImage(imageUrl, "E:\\a.gif", 0, 40, 500,211);
			BufferedImage image = DrawerUtils.cutRemoteImage(imageUrl1, 0, 40, 500,211);
			System.out.println(" bufferImage   " + image);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void alphaImage(){
//	  try {
//	    BufferedImage bi = artService.removeWatermark("江育恒", "901", "#ffffff", "#ffffff", "#000000");
//	    DrawerUtils.alphaImage(bi, "F:\\alpha.png");
//    } catch (Exception e){
//      e.printStackTrace();
//    }
  }
}
