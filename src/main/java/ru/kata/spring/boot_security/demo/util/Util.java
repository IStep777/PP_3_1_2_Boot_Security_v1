package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class Util {
    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public Util(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @Bean
    public void fillDataBase() {

        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");

        Set<Role> adminSet = new HashSet<>();
        adminSet.add(admin);
        //adminSet.add(user);

        Set<Role> userSet = new HashSet<>();
        userSet.add(user);

        User user1 = new User("admin", "admin",
                "admin@mail.ru", adminSet);
        User user2 = new User("user", "user",
                "user@mail.ru", userSet);
        userService.saveUser(user1);
        userService.saveUser(user2);

    }
}
