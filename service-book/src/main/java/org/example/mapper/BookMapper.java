package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Book;

/**
 * @author whm
 * @date 2023/7/30 15:46
 */
@Mapper
public interface BookMapper {
    @Select("select * from BOOK where bid = #{bid}")
    Book getBookById(int bid);
}
