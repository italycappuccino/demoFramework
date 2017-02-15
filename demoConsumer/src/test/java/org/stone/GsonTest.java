package org.stone;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.stone.entity.User;

/**
 * Created by liulei on 2017-02-15.
 */
@RunWith(SpringRunner.class)
@Slf4j
public class GsonTest {

    @Test
    public void test(){
        Gson gson = new Gson();
        User user = new User();
        user.setName("asdf");
        user.setUid(103l);
        user.setIdentity("23423412");
        user.setAge(30);
        //{"name":"asdf","age":30,"uid":103,"identity":"23423412"}
        log.info(gson.toJson(user, User.class));
    }
}
