package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.Book;
import org.example.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author whm
 * @date 2023/7/30 15:49
 */
@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @RequestMapping("/book/{bid}")
    public Book getBookById(@PathVariable("bid") int bid) {
        return bookService.getBookById(bid);
    }

    @RequestMapping("/book/remain/{bid}")
    public int bookRemain(@PathVariable("bid") int bid){
        return bookService.getRemain(bid);
    }

    @RequestMapping("/book/borrow/{bid}")
    public boolean bookBorrow(@PathVariable("bid") int bid){
        int remain = bookService.getRemain(bid);
        return bookService.setRemain(bid, remain - 1);
    }
}
