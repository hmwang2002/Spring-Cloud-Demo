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
}
