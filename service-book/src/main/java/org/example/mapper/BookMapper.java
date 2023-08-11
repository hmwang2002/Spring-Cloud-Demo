package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.entity.Book;

/**
 * @author whm
 * @date 2023/7/30 15:46
 */
@Mapper
public interface BookMapper {
    @Select("select * from BOOK where bid = #{bid}")
    Book getBookById(int bid);

    @Select("select count from BOOK  where bid = #{bid}")
    int getRemain(int bid);

    @Update("update BOOK set count = #{count}  where bid = #{bid}")
    int setRemain(int bid, int count);
}
