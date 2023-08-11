package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserEntity;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author whm
 * @date 2023/7/30 15:39
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public UserEntity getUserById(int uid) {
        return userMapper.getUserById(uid);
    }

    @Override
    public int getRemain(int uid) {
        return userMapper.getUserBookRemain(uid);
    }

    @Override
    public boolean setRemain(int uid, int count) {
        return userMapper.updateBookCount(uid, count) > 0;
    }
}
