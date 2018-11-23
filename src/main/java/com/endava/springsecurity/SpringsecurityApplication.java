package com.endava.springsecurity;

import com.endava.springsecurity.application.dao.RoleDao;
import com.endava.springsecurity.application.model.Role;
import com.endava.springsecurity.application.model.User;
import com.endava.springsecurity.application.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner{


    Logger logger= LoggerFactory.getLogger(SpringsecurityApplication.class);

    @Autowired
    RoleDao roleDao;

    @Autowired
    UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(SpringsecurityApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting Spring Boot app");
        Role role=new Role("ROLE_USER");
        roleDao.save(role);

        logger.info("Role saved");

        logger.info("Saving a user");
        User user=new User("username","$2y$12$fDn63An8qVNi4wiMYOC.SemE.W7w8PaJl9OMbhTHGV4crofl2t5Um/$2y",true,role);
        userService.save(user);
        logger.info("User saved");

        logger.info("Add a new  type of Role");
        Role admin=new Role("ROLE_ADMIN");
        roleDao.save(admin);

        logger.info("Admin saved");

        logger.info("Saving a user");
        User user1=new User("user_admin","admin",true,admin);
        userService.save(user1);
        logger.info("User saved");




    }
}
