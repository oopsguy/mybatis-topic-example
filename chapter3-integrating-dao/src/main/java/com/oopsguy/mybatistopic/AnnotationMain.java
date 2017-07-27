package com.oopsguy.mybatistopic;

import com.oopsguy.mybatistopic.entity.User;
import com.oopsguy.mybatistopic.service.Service;
import com.oopsguy.mybatistopic.service.impl.AnnotationService;

import java.util.List;

/**
 * 使用Annotation的DAO
 */
public class AnnotationMain {

    public static void main(String[] args) {
        Service service = new AnnotationService();
        User user = new User();

        user.setUsername("My");
        user.setPassword("Batis");
        service.insert(user);
        System.out.println(user);

        user.setPassword("HelloMyBatis");
        service.update(user);
        user =  service.getById(5);

        List<User> users = service.findAll();
        System.out.println(users);

        service.deleteById(5);
        users = service.findAll();
        System.out.println(users);
    }

}
