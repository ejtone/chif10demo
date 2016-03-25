package com.ejtone.controller;

/**
 * Created by yuanjing on 16/1/5.
 */


import com.ejtone.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>User: Yuanjing
 * <p>Date: 15-12-22
 * <p>Version: 1.0
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
public class UserController {
    static Log log = LogFactory.getLog(UserController.class);

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public boolean deleteUser(@PathVariable("id") Long id) {
        log.info("deleting user, "+id);
        return id==1?true:false;
    }

    @RequestMapping(method = RequestMethod.GET, value ="/{id}")
    public String getUser(@PathVariable("id") Long id){
        User user = new User();
        user.setId(id);
        user.setName("yuan");
        log.info("getting user, "+id);
        return user.getName();
    }
}

