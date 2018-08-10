/**
 * @author eamiear
 * @date 2018/8/9 14:42
 */

package com.ura.admin.oauth2;

import com.ura.admin.entity.SysUserEntity;
import com.ura.admin.entity.SysUserTokenEntity;
import com.ura.admin.service.ShiroService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class OAuth2Realm extends AuthorizingRealm{

    @Autowired
    ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        Long userId = user.getUserId();

        Set<String> permissionSet = shiroService.getUserPermissions(userId);

        SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
        auth.setStringPermissions(permissionSet);
        return auth;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String accessToken = (String)authenticationToken.getPrincipal();

        SysUserTokenEntity token = shiroService.queryByToken(accessToken);

        if (token == null || token.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        SysUserEntity user = shiroService.queryUser(token.getUserId());

        if (user.getLocked() == 0){
            throw new LockedAccountException("账号已被锁定");
        }

        SimpleAuthenticationInfo authentication = new SimpleAuthenticationInfo(user, accessToken, getName());
        return authentication;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName(Constant.SHIRO_HASH_ALGORITHM_NAME);
//        hashedCredentialsMatcher.setHashIterations(Constant.SHIRO_HASH_ITERATION);
        super.setCredentialsMatcher(credentialsMatcher);
    }
}
