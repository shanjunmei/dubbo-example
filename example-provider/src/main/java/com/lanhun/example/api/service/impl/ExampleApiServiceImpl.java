package com.lanhun.example.api.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lanhun.example.api.model.ExampleModel;
import com.lanhun.example.api.service.ExampleApiService;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/5/16.
 */
@Service
@Component
public class ExampleApiServiceImpl implements ExampleApiService {

    public ExampleModel example(String name) {
        return null;
    }
}
