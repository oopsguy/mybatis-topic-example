package com.oopsguy.mybatistopic.dao;

import com.oopsguy.mybatistopic.entity.User;

import java.util.List;

/**
 * 用户数据访问对象接口
 */
public interface UserDao {

    /**
     * 添加用户
     *
     * @param user 用户实体对象
     */
    void insert(User user);

    /**
     * 通过id获取用户实体
     *
     * @param id 用户id
     * @return 用户实体
     */
    User getById(Integer id);

    /**
     * 获取所有用户实体
     *
     * @return 所有用户实体
     */
    List<User> findAll();

    /**
     * 跟新用户信息
     *
     * @param user 用户实体对象
     */
    void update(User user);

    /**
     * 根据用户id删除用户
     *
     * @param id 用户id
     */
    void deleteById(Integer id);
}
