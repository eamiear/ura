/**
 * @author eamiear
 * @date 2018/8/9 14:43
 */

package com.ura.admin.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

public class OAuth2Token implements AuthenticationToken{
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
