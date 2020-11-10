package com.ll.springboot_jsp_shiro.config;

import com.ll.springboot_jsp_shiro.shiro.cache.RedisCacheManager;
import com.ll.springboot_jsp_shiro.shiro.realms.CustomerReal;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

/**
 * @ClassName shiroConfig
 * @Description
 * @Author 李振兴
 * @Date 2020/11/8 12:41
 **/
@Configuration
public class shiroConfig {


    //1.创建shiroFilter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源和公共资源
        HashMap<String, String> map = new HashMap<>();
        map.put("/user/register","anon");//authc 请求这个资源需要认证和授权
        map.put("/user/login","anon");//authc 请求这个资源需要认证和授权
        map.put("/register.jsp","anon");//authc 请求这个资源需要认证和授权
        map.put("/**","authc");//authc 请求这个资源需要认证和授权

        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/login.jsp");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return shiroFilterFactoryBean;
    }
    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager defaultSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //3.创建自定义realm
    @Bean
    @Primary
    public Realm gerRealm(){
        CustomerReal realm = new CustomerReal();
        HashedCredentialsMatcher credentialsMatcher =  new HashedCredentialsMatcher();
        //设置加密算法
        credentialsMatcher.setHashAlgorithmName("md5");
        //设置哈希散列
        credentialsMatcher.setHashIterations(1024);

        realm.setCredentialsMatcher(credentialsMatcher);
        //设置redis缓存
        realm.setCacheManager(new RedisCacheManager());
        realm.setCachingEnabled(true);//开启全局缓存
        realm.setAuthenticationCachingEnabled(true);//认证缓存
        realm.setAuthenticationCacheName("authenticationCache");
        realm.setAuthorizationCachingEnabled(true);//开启授权缓存
        realm.setAuthorizationCacheName("authorizationCache");
        return realm;
    }

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redisTemplate=new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
