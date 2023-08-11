package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.entity.Book;
import org.example.mapper.BookMapper;
import org.example.service.BookService;
import org.springframework.stereotype.Service;

/**
 * @author whm
 * @date 2023/7/30 15:48
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookMapper bookMapper;
    @Override
    public Book getBookById(int bid) {
        return bookMapper.getBookById(bid);
    }

    @Override
    public boolean setRemain(int bid, int count) {
        return bookMapper.setRemain(bid, count) > 0;
    }

    @Override
    public int getRemain(int bid) {
        return bookMapper.getRemain(bid);
    }
}
