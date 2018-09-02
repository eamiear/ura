/**
 * @author eamiear
 * @date 2018/8/9 15:19
 */

package com.ura.admin.oauth2;

import com.alibaba.fastjson.JSON;
import com.ura.common.utils.HttpContextUtils;
import com.ura.common.utils.R;
import com.ura.common.utils.StatusCodeConstant;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OAuth2Filter extends AuthenticatingFilter{
    @Override
    protected boolean isRememberMe(ServletRequest request) {
        return super.isRememberMe(request);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
      if(((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())){
        return true;
      }
      return false;
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        if (StringUtils.isBlank(token)){
            return null;
        }
        return new OAuth2Token(token);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

        try {
            Throwable throwable = e.getCause() == null ? e: e.getCause();
            String className = throwable.getClass().getSimpleName();
            int code = 0;
            if ("IncorrectCredentialsException".equalsIgnoreCase(className)) {
              code = StatusCodeConstant.TOKEN_EXPIRE;
            } else if ("LockedAccountException".equalsIgnoreCase(className)) {
              code = StatusCodeConstant.USER_ACCOUNT_FORBIDDEN;
            }
            R r = R.error(code, throwable.getMessage());

            String json = JSON.toJSONString(r);
            httpResponse.getWriter().print(json);
        } catch (IOException e1){

        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest)servletRequest);
        if (StringUtils.isBlank(token)){
            HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtils.getOrigin());

            String json = JSON.toJSONString(R.error(StatusCodeConstant.TOKEN_INVALID, "invalid token"));
            httpResponse.getWriter().print(json);

            return false;
        }
        return executeLogin(servletRequest, servletResponse);
    }

    private String getRequestToken(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        if (StringUtils.isBlank(token)){
            token = httpServletRequest.getParameter("token");
        }
        return token;
    }
}

