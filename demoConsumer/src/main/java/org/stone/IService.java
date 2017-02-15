package org.stone;

import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.RequestBody;
import org.stone.entity.Result;
import org.stone.entity.User;

/**
 * Created by liulei on 2017-02-14.
 */
public interface IService {
    @RequestLine("GET /hello/{name}")
    Result<String> hello(@Param("name") String name);
}
