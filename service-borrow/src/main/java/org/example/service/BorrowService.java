package org.example.service;

import org.example.entity.UserBorrowDetail;

/**
 * @author whm
 * @date 2023/7/30 15:57
 */
public interface BorrowService {
    UserBorrowDetail getUserBorrowDetailByUid(int uid);
}
