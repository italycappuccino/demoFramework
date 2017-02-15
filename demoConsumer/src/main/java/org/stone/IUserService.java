package org.stone;

import feign.Headers;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import org.stone.entity.Result;
import org.stone.entity.User;

/**
 * Created by liulei on 2017-02-14.
 */
public interface IUserService {

    @RequestLine("POST /user/update")
    @Headers("Content-Type: application/json")
    Result<User> updateUser(User user);

    @RequestLine("POST /user/info")
    @Headers("Content-Type: application/json")
    User findUser(User user);
}
