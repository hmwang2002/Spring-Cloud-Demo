package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.entity.Borrow;

import java.util.List;

/**
 * @author whm
 * @date 2023/7/30 15:56
 */
@Mapper
public interface BorrowMapper {
    @Select("select * from BORROW where uid = #{uid}")
    List<Borrow> getBorrowsByUid(int uid);

    @Select("select * from BORROW where bid = #{bid}")
    List<Borrow> getBorrowsByBid(int bid);

    @Select("select * from BORROW where bid = #{bid} and uid = #{uid}")
    Borrow getBorrow(int uid, int bid);
}
