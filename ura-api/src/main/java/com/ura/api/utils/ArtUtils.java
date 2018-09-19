/**
 * @author eamiear
 * @date 2018/9/17 14:10
 */

package com.ura.api.utils;

import com.ura.api.bean.JiqieBean;
import com.ura.common.utils.DrawerUtils;
import com.ura.common.utils.HttpUtils;
import com.ura.common.utils.ImageUtils;
import com.ura.common.utils.JSONResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.util.Map;

@Component
public class ArtUtils {

    private static String IMAGE_SUFFIX = "";

    @Autowired
    private JiqieBean jiqieBean;

    /**
     * 生成签名图片<img>标签
     * param name
     * @param fontFamily
     * @param background
     * @param decorator
     * @param color
     * @return
     */
    private String createSignatureImageViaThirdServer(String name, String fontFamily, String background, String decorator, String color) {
        Map<String, Object> params = JSONResult.build()
                .put("id", name)
                .put("idi", jiqieBean.getHost())
                .put("id1", fontFamily)
                .put("id2", background)
                .put("id4", decorator)
                .put("id6", color);
        return HttpUtils.URLPost(jiqieBean.getUrl(), params, true);
    }

    /**
     * 截图图片有效路径
     * @param imageTag
     * @return
     */
    private String getUrlFromSignatureImageTag(String imageTag) {
        if (null == imageTag) return "";
        return imageTag.substring(imageTag.indexOf("/"), imageTag.lastIndexOf("?"));
    }

    /**
     * 获取图片访问路径
     * @param partial
     * @return
     */
    private String getVisitedImageUrl(String partial){
        if (null == partial) return "";
        jiqieBean.setSuffix(partial.substring(partial.lastIndexOf(".") + 1));
        IMAGE_SUFFIX = jiqieBean.getSuffix();
        return jiqieBean.getDomain() + partial;
    }

    /**
     * 移除水印
     * @param name
     * @param fontFamily
     * @param background
     * @param decorator
     * @param color
     * @return
     * @throws Exception
     */
    public BufferedImage removeWatermark(String name, String fontFamily, String background, String decorator, String color) throws Exception{
        String imageContent = createSignatureImageViaThirdServer(name, fontFamily, background, decorator, color);
        String partialUrl = getUrlFromSignatureImageTag(imageContent);
        String remoteUrl = getVisitedImageUrl(partialUrl);
        BufferedImage bi = DrawerUtils.cutRemoteImage(
                remoteUrl,
                Integer.valueOf(jiqieBean.getRectX()),
                Integer.valueOf(jiqieBean.getRectY()),
                Integer.valueOf(jiqieBean.getRectWidth()),
                Integer.valueOf(jiqieBean.getRectHeight()));

        return bi;
    }

    public void write(BufferedImage bi, String suffix, HttpServletResponse response) throws Exception{
        if (StringUtils.isBlank(suffix)) {
            suffix = "png";
        }
        if (jiqieBean.getSuffix() != null) {
            suffix = jiqieBean.getSuffix();
        }
        ImageIO.write(bi, suffix, response.getOutputStream());
    }

    public void write(BufferedImage bi, HttpServletResponse response) throws Exception{
        String suffix = "gif";
        if (StringUtils.isNotBlank(IMAGE_SUFFIX)){
            suffix = IMAGE_SUFFIX;
        }
        write(bi, suffix, response);
    }

    public String write(BufferedImage bi) throws Exception{
        String suffix = "gif";
        if (StringUtils.isNotBlank(IMAGE_SUFFIX)){
            suffix = IMAGE_SUFFIX;
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bi, suffix, os);
//        return StreamUtils.copyToString(new ByteArrayInputStream(os.toByteArray()), Charset.forName("UTF-8"));
//        return os.size() > 0 ? os.toByteArray().toString() : "";
        return ImageUtils.bufferedImageToBase64Str(bi);
    }

}
