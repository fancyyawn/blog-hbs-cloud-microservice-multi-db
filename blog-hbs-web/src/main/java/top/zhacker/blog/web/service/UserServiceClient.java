package top.zhacker.blog.web.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import top.zhacker.blog.web.model.User;

/**
 * DATE: 17/1/13 下午3:48 <br>
 * MAIL: zhanghecheng@terminus.io <br>
 * AUTHOR: zhanghecheng
 */
@FeignClient("blog-user")
public interface UserServiceClient {

    @RequestMapping(value = "/v1/blog/users/{id}",method = RequestMethod.GET)
    User findUserById(@PathVariable("id") Long id);

    @RequestMapping(value = "/v1/blog/users/name/{name}", method = RequestMethod.GET)
    User findUserByName(@RequestParam("name") String username);

}
