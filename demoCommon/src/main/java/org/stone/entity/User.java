package org.stone.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by liulei on 2017-02-14.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
    private static final long serialVersionUID = -4525618623248507250L;
    private String name;
    private int age;
    private long uid;
    private String identity;
}
