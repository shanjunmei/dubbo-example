package com.lanhun.example.service.impl;

import com.lanhun.example.api.model.ExampleModel;
import com.lanhun.example.service.ExampleService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Administrator on 2017/5/17.
 */
@Service
public class ExampleServiceImpl  implements ExampleService{

    public ExampleModel example(String name) {
        ExampleModel model=new ExampleModel();
        model.setName(name);
        model.setCode(UUID.randomUUID().toString());
        throw new RuntimeException(name);
       // return model;
    }
}
