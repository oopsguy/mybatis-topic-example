package com.oopsguy.mybatistopic.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * MyBatis工具类
 */
public class MyBatisUtil {

    private static final String CONFIG_FILE = "mybatis-config.xml";

    private static SqlSessionFactory sqlSessionFactory = null;

    private MyBatisUtil() {
    }

    /**
     * 获取SqlSessionFactory单例
     *
     * @return SqlSessionFactory实例
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            synchronized (MyBatisUtil.class) {
                if (sqlSessionFactory == null) {
                    try {
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(CONFIG_FILE));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return sqlSessionFactory;
    }

}
