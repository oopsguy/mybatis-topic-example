package com.oopsguy.mybatistopic.service.impl;

import com.oopsguy.mybatistopic.dao.UserDao;
import com.oopsguy.mybatistopic.entity.User;
import com.oopsguy.mybatistopic.service.Service;
import com.oopsguy.mybatistopic.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 使用mapper和interface的DAO
 */
public class InterfaceMapperService implements Service {

    private SqlSessionFactory sessionFactory = null;
    UserDao userDao = null;

    public InterfaceMapperService() {
        this.sessionFactory = MyBatisUtil.getSqlSessionFactory();
    }


    public void insert(User user) {
        SqlSession session = this.sessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
        userDao.insert(user);
        session.commit();
        session.close();
    }

    public User getById(Integer id) {
        SqlSession session = this.sessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
        User user = userDao.getById(id);
        session.close();

        return user;
    }

    public List<User> findAll() {
        SqlSession session = this.sessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
        List<User> users = userDao.findAll();
        session.close();

        return users;
    }

    public void update(User user) {
        SqlSession session = this.sessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
        userDao.update(user);
        session.commit();
        session.close();
    }

    public void deleteById(Integer id) {
        SqlSession session = this.sessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
        userDao.deleteById(id);
        session.commit();
        session.close();
    }
}
