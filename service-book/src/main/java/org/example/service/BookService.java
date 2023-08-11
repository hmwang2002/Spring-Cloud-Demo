package org.example.service;

import org.example.entity.Book;

/**
 * @author whm
 * @date 2023/7/30 15:47
 */
public interface BookService {
    Book getBookById(int bid);

    boolean setRemain(int bid, int count);

    int getRemain(int bid);
}
