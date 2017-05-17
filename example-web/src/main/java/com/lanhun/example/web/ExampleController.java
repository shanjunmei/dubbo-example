package com.lanhun.example.web;

import com.lanhun.example.api.model.ExampleModel;
import com.lanhun.example.api.service.ExampleApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/5/16.
 */
@RestController
@RequestMapping("example")
public class ExampleController {

    @Resource
    private ExampleApiService service;

    @RequestMapping("hello")
    public ExampleModel example(String name){
        return service.example(name);
    }
}
