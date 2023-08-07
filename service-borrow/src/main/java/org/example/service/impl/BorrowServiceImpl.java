package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.controller.client.BookClient;
import org.example.controller.client.UserClient;
import org.example.entity.Book;
import org.example.entity.Borrow;
import org.example.entity.UserBorrowDetail;
import org.example.entity.UserEntity;
import org.example.mapper.BorrowMapper;
import org.example.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author whm
 * @date 2023/7/30 15:58
 */
@Service
@RequiredArgsConstructor
public class BorrowServiceImpl implements BorrowService {
    private final BorrowMapper borrowMapper;

    private final UserClient userClient;

    private final BookClient bookClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrow = borrowMapper.getBorrowsByUid(uid);
        //RestTemplate支持多种方式的远程调用
//        RestTemplate template = new RestTemplate();
        //这里通过调用getForObject来请求其他服务，并将结果自动进行封装
        //获取User信息
        UserEntity user = userClient.getUserById(uid);
        //获取每一本书的详细信息
        List<Book> bookList = borrow
                .stream()
                .map(b -> bookClient.getBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user, bookList);
    }
}
