package org.example.client;

import org.example.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whm
 * @date 2023/8/7 15:02
 */
@FeignClient("UserService")
public interface UserClient {
    @RequestMapping("/user/{uid}")
    UserEntity getUserById(@PathVariable("uid") int uid);
}
