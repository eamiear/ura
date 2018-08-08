package com.ura.admin.shiro;

import com.ura.common.utils.RedisKeys;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
public class RedisShiroSessionDao extends EnterpriseCacheSessionDAO {

  @Autowired
  private RedisTemplate redisTemplate;

  @Override
  protected Serializable doCreate(Session session) {
    Serializable sessionId = super.doCreate(session);
    final String key = RedisKeys.getShiroSessionKey(sessionId.toString());
    setShiroSession(key, session);
    return sessionId;
  }

  @Override
  protected Session doReadSession(Serializable sessionId) {
    Session session = super.doReadSession(sessionId);
    if (session == null) {
      final String key = RedisKeys.getShiroSessionKey(sessionId.toString());
      session = getShiroSeesion(key);
    }
    return session;
  }

  @Override
  protected void doUpdate(Session session) {
    super.doUpdate(session);
    final String key = RedisKeys.getShiroSessionKey(session.getId().toString());
    setShiroSession(key, session);
  }

  @Override
  protected void doDelete(Session session) {
    super.doDelete(session);
    final String key = RedisKeys.getShiroSessionKey(session.getId().toString());
    redisTemplate.delete(key);
  }

  private Session getShiroSeesion(String key){
    return (Session)redisTemplate.opsForValue().get(key);
  }

  public void setShiroSession(String key, Session session){
    redisTemplate.opsForValue().set(key, session);
    redisTemplate.expire(key, 60, TimeUnit.MINUTES);
  }
}
