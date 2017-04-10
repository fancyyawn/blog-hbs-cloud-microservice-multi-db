package top.zhacker.blog.user.service;


import top.zhacker.blog.user.model.User;

/**
 * DATE: 17/1/5 上午10:12 <br>
 * MAIL: hechengopen@gmail.com <br>
 * AUTHOR: zhacker
 *
 * 用户服务
 */
public interface UserService {

    Long createUser(User user);

    User findUserByName(String name);

    User findUserById(Long id);
}
