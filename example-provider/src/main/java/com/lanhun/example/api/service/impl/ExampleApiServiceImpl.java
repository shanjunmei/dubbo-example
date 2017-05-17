package com.lanhun.example.api.service.impl;

import com.lanhun.example.api.model.ExampleModel;
import com.lanhun.example.api.service.ExampleApiService;
import com.lanhun.example.service.ExampleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/16.
 */

@Component
public class ExampleApiServiceImpl implements ExampleApiService {

    @Resource
    private ExampleService service;

    public ExampleModel example(String name) {
        return service.example(name);
    }
}
