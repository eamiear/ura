/**
 * @author eamiear
 * @date 2018/8/9 17:29
 */

package com.ura.admin.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.ura.admin.annotation.SysLog;
import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.service.SysUserService;
import com.ura.admin.service.SysUserTokenService;
import com.ura.admin.shiro.ShiroUtils;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class SysLoginController extends AbstractController{

    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        String text = producer.createText();
        ShiroUtils.setKaptcha(Constants.KAPTCHA_SESSION_KEY, text);
        BufferedImage bi = producer.createImage(text);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
    }

    @ResponseBody
    @RequestMapping("sys/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password,
                   @RequestParam("captcha") String captcha) {
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return R.error(StatusCodeConstant.PARAM_CAPTCHA_ERROR,"验证码错误");
        }

        SysUserEntity user = sysUserService.queryByUserName(username);
        if (user == null || !user.getPassword().equals(ShiroUtils.cryptPassword(password, user.getSalt()))){
            return R.error(StatusCodeConstant.USER_ACCOUNT_ERROR,"账号或密码不正确");
        }

        if (user.getLocked() == 0) {
            return R.error(StatusCodeConstant.USER_ACCOUNT_FORBIDDEN, "账号已被锁定");
        }
        return sysUserTokenService.createToken(user.getUserId());
    }

    @ResponseBody
    @RequestMapping("sys/loginNotCaptcha")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password) {
        SysUserEntity user = sysUserService.queryByUserName(username);
        if (user == null || !user.getPassword().equals(ShiroUtils.cryptPassword(password, user.getSalt()))) {
            return R.error(StatusCodeConstant.USER_ACCOUNT_ERROR,"账号或密码不正确");
        }
        if (user.getLocked() == 0) {
            return R.error(StatusCodeConstant.USER_ACCOUNT_FORBIDDEN,"账号已被锁定");
        }

        return sysUserTokenService.createToken(user.getUserId());
    }

    @SysLog("登出系统")
    @ResponseBody
    @RequestMapping("sys/logout")
    public R logout() {
        sysUserTokenService.updateToken(getUserId());
        return R.success();
    }
}
