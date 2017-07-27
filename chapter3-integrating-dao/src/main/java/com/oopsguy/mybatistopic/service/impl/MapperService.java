package com.oopsguy.mybatistopic.service.impl;

import com.oopsguy.mybatistopic.entity.User;
import com.oopsguy.mybatistopic.service.Service;
import com.oopsguy.mybatistopic.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 使用了mapper定义的DAO
 */
public class MapperService implements Service {

    private SqlSessionFactory sessionFactory = null;

    public MapperService() {
        this.sessionFactory = MyBatisUtil.getSqlSessionFactory();
    }

    public void insert(User user) {
        SqlSession sqlSession = this.sessionFactory.openSession();
        sqlSession.insert("UserDao.insert", user);
        sqlSession.commit();
        sqlSession.close();
    }

    public User getById(Integer id) {
        SqlSession sqlSession = this.sessionFactory.openSession();
        User user = sqlSession.selectOne("UserDao.getById", id);
        sqlSession.close();

        return user;
    }

    public List<User> findAll() {
        SqlSession session = this.sessionFactory.openSession();
        List<User> users = session.selectList("UserDao.findAll");
        session.close();

        return users;
    }

    public void update(User user) {
        SqlSession session = this.sessionFactory.openSession();
        session.update("UserDao.update", user);
        session.commit();
        session.close();
    }

    public void deleteById(Integer id) {
        SqlSession session = this.sessionFactory.openSession();
        session.delete("UserDao.deleteById", id);
        session.commit();
        session.close();
    }

}
