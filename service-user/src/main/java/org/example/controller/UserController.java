package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserEntity;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whm
 * @date 2023/7/30 15:40
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping("/user/{uid}")
    public UserEntity findUserById(@PathVariable("uid") int uid) {
        return userService.getUserById(uid);
    }
}
