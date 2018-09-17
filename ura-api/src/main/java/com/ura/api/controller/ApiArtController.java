/**
 * @author eamiear
 * @date 2018/9/17 11:46
 */

package com.ura.api.controller;

import com.ura.api.annotation.IgnoreAuth;
import com.ura.api.utils.ArtUtils;
import com.ura.common.utils.DrawerUtils;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@RequestMapping("/api/art")
@Api(tags = "签名接口")
public class ApiArtController {

    @Autowired
    private ArtUtils artService;

    private final static String SIGN_BG = "#ffffff";
    private final static int COLOR_RANGE = 120;

    @IgnoreAuth
    @GetMapping("s/create")
    @ApiOperation("生成白色背景签名")
    public R create(
        @ApiParam(value = "签名名称") @RequestParam(value = "text", defaultValue = "周杰伦") String text,
        @ApiParam(value = "字体类型") @RequestParam(value = "style", defaultValue = "901") String style,
        @ApiParam(value = "字体配色") @RequestParam(value = "decorator", defaultValue = "#ffffff") String decorator,
        @ApiParam(value = "字体颜色") @RequestParam(value = "color", defaultValue = "#000000") String color,
        HttpServletResponse response) {
        if (StringUtils.isBlank(text)) {
            return R.error(StatusCodeConstant.PARAM_NOT_EMPTY, "请输入姓名");
        }
        if (text.length() < 2) {
            return R.error(StatusCodeConstant.PARAM_SIZE_INVALID, "请输入至少两个字");
        }
        try {
            BufferedImage bi = artService.removeWatermark(text, style, handleColor(SIGN_BG), handleColor(decorator), handleColor(color));
            artService.write(bi, response);
            return R.success("签名生成成功");
        } catch (Exception e) {
            return R.error().put("msg", e);
        }
    }

    @IgnoreAuth
    @GetMapping("s/alpha")
    @ApiOperation("生成背景色透明签名")
    public R alpha (
            @ApiParam(value = "签名名称") @RequestParam(value = "text", defaultValue = "周杰伦") String text,
            @ApiParam(value = "字体类型") @RequestParam(value = "style", defaultValue = "901") String style,
            @ApiParam(value = "字体配色") @RequestParam(value = "decorator", defaultValue = "#ffffff") String decorator,
            @ApiParam(value = "字体颜色") @RequestParam(value = "color", defaultValue = "#000000") String color,
            HttpServletResponse response) {
        if (StringUtils.isBlank(text)) {
            return R.error(StatusCodeConstant.PARAM_NOT_EMPTY, "请输入姓名");
        }
        if (text.length() < 2) {
            return R.error(StatusCodeConstant.PARAM_SIZE_INVALID, "请输入至少两个字");
        }
        try {
            BufferedImage bi = artService.removeWatermark(text, style, handleColor(SIGN_BG), handleColor(decorator), handleColor(color));
            bi = DrawerUtils.transparentImage(bi, COLOR_RANGE, 0);
            artService.write(bi, response);
            return R.success("签名生成成功");
        } catch (Exception e) {
            return R.error().put("msg", e);
        }
    }

    @IgnoreAuth
    @GetMapping("s/scale")
    @ApiOperation("缩放或放大签名")
    public R scale(
            @ApiParam(value = "签名名称") @RequestParam(value = "text", defaultValue = "周杰伦") String text,
            @ApiParam(value = "字体类型") @RequestParam(value = "style", defaultValue = "901") String style,
            @ApiParam(value = "字体配色") @RequestParam(value = "decorator", defaultValue = "#ffffff") String decorator,
            @ApiParam(value = "字体颜色") @RequestParam(value = "color", defaultValue = "#000000") String color,
            @ApiParam(value = "缩放宽度") @RequestParam(value ="width", defaultValue = "350") int width,
            @ApiParam(value = "缩放高度") @RequestParam(value ="width", defaultValue = "160") int height,
            HttpServletResponse response) {
        if (StringUtils.isBlank(text)) {
            return R.error(StatusCodeConstant.PARAM_NOT_EMPTY, "请输入姓名");
        }
        if (text.length() < 2) {
            return R.error(StatusCodeConstant.PARAM_SIZE_INVALID, "请输入至少两个字");
        }
        try {
            BufferedImage bi = artService.removeWatermark(text, style, handleColor(SIGN_BG), handleColor(decorator), handleColor(color));
            bi = DrawerUtils.transparentImage(bi, COLOR_RANGE, 0);
            bi = DrawerUtils.alpha1(bi);
            BufferedImage scaleImage = DrawerUtils.scaleImage(bi, width, height);
            artService.write(scaleImage, response);
            return R.success("签名生成成功");
        } catch (Exception e) {
            return R.error().put("msg", e);
        }
    }

    private String handleColor(String color){
        if (!color.contains("#")) {
            color = "#" + color;
        }
        return color;
    }
}
