package org.example.controller.client;

import org.example.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whm
 * @date 2023/8/5 13:54
 */
@FeignClient(value = "UserService", fallback = UserFallbackClient.class)
public interface UserClient {

    //路径保证和其他微服务提供的一致即可
    @RequestMapping("/user/{uid}")
    UserEntity getUserById(@PathVariable("uid") int uid);  //参数和返回值也保持一致
}
