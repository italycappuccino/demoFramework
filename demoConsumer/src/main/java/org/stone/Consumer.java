package org.stone;

import com.alibaba.fastjson.JSONObject;
import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.httpclient.ApacheHttpClient;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.stone.entity.Result;
import org.stone.entity.User;

import java.util.UUID;

/**
 * Created by liulei on 2017-02-14.
 */
@SpringBootApplication
@RestController
@Slf4j
public class Consumer {
    public static void main(String[] args) {
        SpringApplication.run(Consumer.class,args);
    }

    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public Result<String> sayHello(@PathVariable String name){

        IService service = Feign.builder()
                .decoder(new GsonDecoder())
                .target(IService.class,"http://localhost:8087");

        return service.hello(name);
    }

    @RequestMapping(value = "/user/{uid}",method = RequestMethod.GET)
    public Result<User> updateUser(@PathVariable long uid){
        log.info("================================="+ uid);
        IUserService service = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(IUserService.class,"http://localhost:8087");
        User user = new User();
        user.setUid(uid);
        log.info("================================="+ JSONObject.toJSONString(user));
        return service.updateUser(user);
    }

    @RequestMapping(value = "/userInfo/{uid}",method = RequestMethod.GET)
    public User findUser(@PathVariable long uid){
        IUserService service = Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(IUserService.class,"http://localhost:8087");
        User user = new User();
        user.setUid(uid);
        return service.findUser(user);
    }
}
