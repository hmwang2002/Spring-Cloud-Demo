package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.entity.UserEntity;

/**
 * @author whm
 * @date 2023/7/30 15:37
 */
@Mapper
public interface UserMapper {
    @Select("select * from USER where uid = #{uid}")
    UserEntity getUserById(int uid);

    @Select("select book_count from USER where uid = #{uid}")
    int getUserBookRemain(int uid);

    @Update("update USER set book_count = #{count} where uid = #{uid}")
    int updateBookCount(int uid, int count);
}
