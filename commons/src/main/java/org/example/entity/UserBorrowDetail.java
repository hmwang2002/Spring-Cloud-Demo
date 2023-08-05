package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author whm
 * @date 2023/7/30 15:56
 */
@Data
@AllArgsConstructor
public class UserBorrowDetail {
    UserEntity user;
    List<Book> bookList;
}
