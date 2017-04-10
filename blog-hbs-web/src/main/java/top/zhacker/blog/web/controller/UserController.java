package top.zhacker.blog.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.zhacker.blog.web.model.User;
import top.zhacker.blog.web.service.UserServiceClient;

/**
 * DATE: 17/1/13 下午3:54 <br>
 * MAIL: zhanghecheng@terminus.io <br>
 * AUTHOR: zhanghecheng
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceClient userClient;

    @RequestMapping(value = "/users/id/{userId}",method = RequestMethod.GET)
    public User findUserById(@PathVariable("userId") Long userId){
        return userClient.findUserById(userId);
    }

    @RequestMapping(value = "/users/name/{name}",method = RequestMethod.GET)
    public User findUserByName(@PathVariable String name){
        return userClient.findUserByName(name);
    }
}
