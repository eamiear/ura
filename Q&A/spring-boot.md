# redis key值出现`\xAC\xED\x00\x05t\x00`可能的情况
1. RedisConfig的配置是否与当前项目同级
```java
package com.ura.common.config;
@Configuration
public class RedisConfig {
    @Autowired
    private RedisConnectionFactory factory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, String> valueOperations(RedisTemplate<String, String> redisTemplate){
        return redisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate){
        return redisTemplate.opsForZSet();
    }
}
```

```
@Configuration 注解会自动扫描同级或子级配置到spring AOP容器中
```
如果项目（```comm.ura.admin```）要引用RedisConfig的redis的配置时，直接启动容器是无法初始化RedisConfig配置信息的。
可以的处理如下：
1. 将RedisConfig放到与应用同级目录或子目录下```com.ura.admin.config```
2. 项目启动文件中，配置项目包扫描的路径
```java
@SpringBootApplication(scanBasePackages = "com.ura")
public class AdminApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdminApplication.class);
	}
}

```


# 前后端分离、每次请求都会生成不同的 shiro session
> 前后端分离、axios跨域请求时，登陆前将验证码存储到session中，登陆后从session中取出验证码进行校验。
> 但每次存验证码和取验证码时，都会产生不同的session、sessionId。
> 后端有正确的cors配置。

问题原因：

> 客户端访问系统时，后端生成一个会话Id（sessionId）并在响应体中以SET-COOKIE字段返回，并存到客户端Cookie中，其中```JSESSIONID```即代表sessionId。此时会话建立。往后的请求都基于该会话进行通信，即将sessionId作为同一会话凭据，除非会话失效等。
> 客户端请求时，每次都产生一个新的session和session id。说明建立会话后，客户端没有正常保存sessionId，并传递到后端。
> 观察发现，get请求正常，post则会出现问题。
> axios post跨域请求时，默认不携带浏览器的cookie信息

解决：
在axios请求中添加withCredentials: true 配置项，表示跨域请求时需要使用凭证

```javascript
const service = axios.create({
  baseURL: process.env.BASE_API,
  withCredentials: true,
  timeout: 16000
})
```
