package top.zhacker.blog.web.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;
import top.zhacker.blog.web.model.User;

/**
 * DATE: 17/1/13 下午3:48 <br>
 * MAIL: zhanghecheng@terminus.io <br>
 * AUTHOR: zhanghecheng
 */
@FeignClient("blog-user")
@RequestMapping("/v1/blog/users")
public interface UserServiceClient {

    @RequestMapping(value = "", method = RequestMethod.POST)
    Long createUser(@RequestBody User user);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User findUserById(@PathVariable("id") Long id);

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    User findUserByName(@PathVariable("name") String name);
}
