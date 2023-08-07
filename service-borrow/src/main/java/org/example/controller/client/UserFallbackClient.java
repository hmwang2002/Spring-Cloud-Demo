package org.example.controller.client;

import org.example.entity.UserEntity;
import org.springframework.stereotype.Component;

/**
 * @author whm
 * @date 2023/8/5 20:14
 */
@Component   //注意，需要将其注册为Bean，Feign才能自动注入
public class UserFallbackClient implements UserClient{
    @Override
    public UserEntity getUserById(int uid) {   //这里我们自行对其进行实现，并返回我们的替代方案
        UserEntity user = new UserEntity();
        user.setName("我是替代方案");
        return user;
    }
}
