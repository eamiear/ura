/**
 * @author eamiear
 * @date 2018/8/10 14:40
 */

package com.ura.common.utils;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  <pre>
 *     jwt的claim里一般包含以下几种数据:
 *         1. iss -- token的发行者
 *         2. sub -- 该JWT所面向的用户
 *         3. aud -- 接收该JWT的一方
 *         4. exp -- token的失效时间
 *         5. nbf -- 在此时间段之前,不会被处理
 *         6. iat -- jwt发布时间
 *         7. jti -- jwt唯一标识,防止重复使用
 * </pre>
 */

@Component
public class JwtTokenUtils {

    public static String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + Constant.JWT_EXPIRATION_TIME);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, Constant.JWT_SECRET)
                .compact();
    }

    public static Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(Constant.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getUserName(String token) {
        return getClaims(token).getSubject();
    }

    public static Date getTokenCreatedDate(String token) {
        return getClaims(token).getIssuedAt();
    }

    public static Date getTokenExpiration(String token){
        return getClaims(token).getExpiration();
    }

    /**
     * 获取jwt接收者
     * @param token
     * @return
     */
    public static String getAudience(String token) {
        return getClaims(token).getAudience();
    }

    public static String getPrivateClaims(String token, String key) {
        return getClaims(token).get(key).toString();
    }

    public static Boolean isTokenExpired(String token) {
        try {
            final Date expiration = getTokenExpiration(token);
            return expiration.before(new Date());
        } catch (ExpiredJwtException e) {
            return true;
        }
    }
}
