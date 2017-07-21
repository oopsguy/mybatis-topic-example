package com.oopsguy.mybatistopic;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        //获取配置文件信息
        InputStream resStream = Resources.getResourceAsStream("mybatis-config.xml");
        //通过配置参数构建sqlSessionFactory工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resStream);
        //开启数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("username", "hello");
        params.put("password", "world");
        //插入数据
        sqlSession.insert("UserMapper.insertUser", params);
        //提交事务
        sqlSession.commit();
        //插叙数据
        Map<String, Object> result = sqlSession.selectOne("UserMapper.selectUser", "hello");
        System.out.println(result);
        //释放资源
        sqlSession.close();
    }

}
