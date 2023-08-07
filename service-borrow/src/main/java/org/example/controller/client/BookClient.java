package org.example.controller.client;

import org.example.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whm
 * @date 2023/8/5 13:56
 */
@FeignClient("BookService")
public interface BookClient {
    @RequestMapping("/book/{bid}")
    Book getBookById(@PathVariable("bid") int bid);
}
