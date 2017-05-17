package com.lanhun.example.api.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/16.
 */
public class ExampleModel implements Serializable {
    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
