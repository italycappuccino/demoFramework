package org.stone;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.stone.entity.Result;
import org.stone.entity.User;

import java.util.UUID;

/**
 * Created by liulei on 2017-02-14.
 */
@SpringBootApplication
@RestController
@Slf4j
public class Producer {
    public static void main(String[] args) {
        SpringApplication.run(Producer.class,args);
    }

    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public Result<String> hello(@PathVariable String name){
        return new Result<>("hello, "+name);
    }

    @RequestMapping(value = "/user/update",method = RequestMethod.POST)
    public Result<User> updateUser(@RequestBody User user){

        log.info("================================="+ JSONObject.toJSONString(user));
        User tmpUser = new User();
        tmpUser.setUid(user.getUid());
        tmpUser.setAge(30);
        tmpUser.setIdentity(UUID.randomUUID().toString());
        tmpUser.setName("test");

        log.info("================================="+ JSONObject.toJSONString(tmpUser));

        return new Result<>(tmpUser);
    }

    @RequestMapping(value = "/user/info",method = RequestMethod.POST)
    public User findUser(@RequestBody User user){
        log.info("================================="+ JSONObject.toJSONString(user));
        User tmpUser = new User();
        tmpUser.setUid(user.getUid());
        tmpUser.setAge(30);
        tmpUser.setIdentity(UUID.randomUUID().toString());
        tmpUser.setName("test");
        log.info("================================="+ JSONObject.toJSONString(tmpUser));
        return tmpUser;
    }
}
