package org.example.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.RequiredArgsConstructor;
import org.example.client.BookClient;
import org.example.client.UserClient;
import org.example.entity.Book;
import org.example.entity.Borrow;
import org.example.entity.UserBorrowDetail;
import org.example.entity.UserEntity;
import org.example.mapper.BorrowMapper;
import org.example.service.BorrowService;
import org.springframework.stereotype.Service;

import java.util.Collections;
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

    private final BookClient bookClient;

    private final UserClient userClient;
    @Override
    @SentinelResource(value = "getBorrow", blockHandler = "blocked")
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

    @GlobalTransactional
    @Override
    public boolean doBorrow(int uid, int bid) {
        //1. 判断图书和用户是否都支持借阅
        if(bookClient.bookRemain(bid) < 1) {
            throw new RuntimeException("图书数量不足");
        }
        if(userClient.userRemain(uid) < 1) {
            throw new RuntimeException("用户借阅量不足");
        }
        //2. 首先将图书的数量-1
        if(!bookClient.bookBorrow(bid)) {
            throw new RuntimeException("在借阅图书时出现错误！");
        }
        //3. 添加借阅信息
        if(borrowMapper.getBorrow(uid, bid) != null) {
            throw new RuntimeException("此书籍已经被此用户借阅了！");
        }
        if(borrowMapper.addBorrow(uid, bid) <= 0) {
            throw new RuntimeException("在录入借阅信息时出现错误！");
        }
        //4. 用户可借阅-1
        if(!userClient.userBorrow(uid)) {
            throw new RuntimeException("在借阅时出现错误！");
        }
        //完成
        return true;
    }

    //替代方案，注意参数和返回值需要保持一致，并且参数最后还需要额外添加一个BlockException
    public UserBorrowDetail blocked(int uid, BlockException e) {
        return new UserBorrowDetail(null, Collections.emptyList());
    }
}
