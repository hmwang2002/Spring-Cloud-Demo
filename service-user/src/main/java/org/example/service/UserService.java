package org.example.service;

import org.example.entity.UserEntity;

/**
 * @author whm
 * @date 2023/7/30 15:38
 */
public interface UserService {
    UserEntity getUserById(int uid);

    int getRemain(int uid);

    boolean setRemain(int uid, int count);
}
