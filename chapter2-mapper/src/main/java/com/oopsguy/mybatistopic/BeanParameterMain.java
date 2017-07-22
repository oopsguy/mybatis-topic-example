package com.oopsguy.mybatistopic;

import com.oopsguy.mybatistopic.bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Map;

/**
 * Java Bean参数
 */
public class BeanParameterMain {

    public static void main(String[] args) {
        SqlSession sqlSession = null;

        try {
            InputStream resStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resStream);
            sqlSession = sqlSessionFactory.openSession();

            String username = "JavaBean";
            User user = new User();
            user.setUsername(username);
            user.setPassword("HelloWorld");
            sqlSession.insert("UserBeanMapper.insert", user);
            sqlSession.commit();

            Map<String, Object> ret = sqlSession.selectOne("UserBeanMapper.selectByUsername", username);
            System.out.println(ret);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

}
