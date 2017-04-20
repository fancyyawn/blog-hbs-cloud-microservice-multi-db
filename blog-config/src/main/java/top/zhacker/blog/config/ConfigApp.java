package top.zhacker.blog.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * DATE: 2017/4/20 <br>
 * MAIL: hechengopen@gmail.com <br>
 * AUTHOR: zhacker
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigApp {

    public static void main(String[] args){
        SpringApplication.run(ConfigApp.class, args);
    }
}
