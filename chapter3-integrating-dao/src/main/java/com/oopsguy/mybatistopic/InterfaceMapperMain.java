package com.oopsguy.mybatistopic;

import com.oopsguy.mybatistopic.entity.User;
import com.oopsguy.mybatistopic.service.Service;
import com.oopsguy.mybatistopic.service.impl.InterfaceMapperService;

import java.util.List;

public class InterfaceMapperMain {

    public static void main(String[] args) {
        Service service = new InterfaceMapperService();
        User user = new User();

        user.setUsername("Hello");
        user.setPassword("World");
        service.insert(user);
        System.out.println(user);

        user.setPassword("WorldPassword");
        service.update(user);
        user =  service.getById(4);

        List<User> users = service.findAll();
        System.out.println(users);

        service.deleteById(4);
        users = service.findAll();
        System.out.println(users);
    }

}
