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

        int id = 1;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        params.put("username", "hello");
        params.put("password", "world");

        //使用命名空间为UserMapper的id为insert的SQL执行insert操作
        sqlSession.insert("UserMapper.insert", params);
        sqlSession.commit();

        params.clear();
        params.put("username", "oopsguy");
        params.put("id", id);
        sqlSession.update("UserMapper.updateUsernameById", params);
        sqlSession.commit();

        //使用命名空间为UserMapper的id为selectById的SQL段执行select操作，取一条结果集
        Map<String, Object> result = sqlSession.selectOne("UserMapper.selectById", id);
        System.out.println("添加修改后：" + result);

        //使用UserMapper的id为deleteById的SQL段执行删除操作
        sqlSession.delete("UserMapper.deleteById", id);
        sqlSession.commit();

        //检查结果是否存在
        result = sqlSession.selectOne("UserMapper.selectById", id);
        System.out.println("删除后： " + result);

        //释放资源
        sqlSession.close();
    }

}
