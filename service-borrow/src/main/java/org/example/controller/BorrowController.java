package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserBorrowDetail;
import org.example.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whm
 * @date 2023/7/30 16:00
 */
@RestController
@RequiredArgsConstructor
public class BorrowController {
    private final BorrowService borrowService;

    @RequestMapping("/borrow/{uid}")
    UserBorrowDetail findUserBorrows(@PathVariable("uid") int uid){
        return borrowService.getUserBorrowDetailByUid(uid);
    }
}
