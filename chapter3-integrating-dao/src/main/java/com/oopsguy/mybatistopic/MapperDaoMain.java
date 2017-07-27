package com.oopsguy.mybatistopic;

import com.oopsguy.mybatistopic.entity.User;
import com.oopsguy.mybatistopic.service.Service;
import com.oopsguy.mybatistopic.service.impl.MapperService;

import java.util.List;

/**
 * 使用mapper定义的DAO
 */
public class MapperDaoMain {

    public static void main(String[] args) {
        Service service = new MapperService();
        User user = new User();

        //添加
        user.setPassword("password11111");
        user.setUsername("username11111");
        service.insert(user);
        System.out.println(user);

        user.setUsername("username2222");
        user.setPassword("password2222");
        service.insert(user);
        System.out.println(user);

        //修改
        user.setUsername("Oopsguy");
        service.update(user);

        //获取单个
        user = service.getById(1);
        System.out.println(user);

        //获取全部
        List<User> users = service.findAll();
        System.out.println(users);

        //删除
        service.deleteById(1);
        users = service.findAll();
        System.out.println(users);
    }

}
