package com.oopsguy.mybatistopic;

import com.oopsguy.mybatistopic.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 结果集使用Bean类型
 */
public class BeanResultMain {

    public static void main(String[] args) throws IOException {
        InputStream resStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("User1");
        user.setPassword("User1_password");
        sqlSession.insert("BeanResultMapper.insert", user);
        user.setUsername("User2");
        user.setPassword("User2_password");
        sqlSession.insert("BeanResultMapper.insert", user);
        sqlSession.commit();

        user = sqlSession.selectOne("BeanResultMapper.selectByUsername", "User1");
        System.out.println(user);

        List<User> users = sqlSession.selectList("BeanResultMapper.selectAll");
        System.out.println(users);

        sqlSession.close();
    }

}
