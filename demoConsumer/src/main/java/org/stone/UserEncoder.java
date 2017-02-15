package org.stone;

import com.alibaba.fastjson.JSONObject;
import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

import java.lang.reflect.Type;

/**
 * Created by liulei on 2017-02-14.
 */
public class UserEncoder implements Encoder{
    final JSONObject jsonObject;

    public UserEncoder(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    @Override
    public void encode(Object o, Type type, RequestTemplate requestTemplate) throws EncodeException {
//        requestTemplate.body(jsonObject.);
    }
}
