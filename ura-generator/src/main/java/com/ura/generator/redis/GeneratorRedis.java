/**
 * @author eamiear
 * @date 2018/8/3 11:45
 */

package com.ura.generator.redis;

import com.ura.common.utils.RedisKeys;
import com.ura.common.utils.RedisUtils;
import com.ura.generator.entity.PropsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneratorRedis {

    @Autowired
    private RedisUtils redisUtils;

    public void set(PropsEntity propsEntity){
        if (propsEntity != null){
            String key = RedisKeys.getGeneratorKey(propsEntity.getKey());
            redisUtils.set(key, propsEntity);
        }
    }

    public PropsEntity get(String propsKey){
        String key = RedisKeys.getGeneratorKey(propsKey);
        return redisUtils.get(key, PropsEntity.class);
    }

    public void delete(String propsKey){
        String key = RedisKeys.getGeneratorKey(propsKey);
        redisUtils.delete(key);
    }
}
