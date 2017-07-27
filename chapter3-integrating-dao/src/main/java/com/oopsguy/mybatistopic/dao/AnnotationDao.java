package com.oopsguy.mybatistopic.dao;

import com.oopsguy.mybatistopic.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AnnotationDao {
    /**
     * 添加用户
     *
     * @param user 用户实体对象
     */
    @Options(useGeneratedKeys = true, keyColumn = "id")
    @Insert("INSERT INTO user (username, password) VALUES (#{username}, #{password})")
    void insert(User user);

    /**
     * 通过id获取用户实体
     *
     * @param id 用户id
     * @return 用户实体
     */
    @Select("SELECT id, username, password FROM user WHERE id=#{id}")
    User getById(@Param("id") Integer id);

    /**
     * 获取所有用户实体
     *
     * @return 所有用户实体
     */
    @Select("SELECT id, username, password FROM user")
    List<User> findAll();

    /**
     * 跟新用户信息
     *
     * @param user 用户实体对象
     */
    @Update("UPDATE user SET username=#{username}, password=#{password} WHERE id=#{id}")
    void update(User user);

    /**
     * 根据用户id删除用户
     *
     * @param id 用户id
     */
    @Delete("DELETE FROM user WHERE id=#{id}")
    void deleteById(Integer id);
}
