package com.example.demo.controller;

import com.example.demo.service.ExampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * (Example)控制层
 *
 * @author code generation
 * @date 2019-11-22 20:33:06
 * @since JDK1.8
 */
@Slf4j
@Validated
@RestController
@Api(tags = "Example", value = "ExampleApi", description = "ExampleApi接口相关")
@RequestMapping(value = "example", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ExampleController {
    private final ExampleService service;


    @Autowired
    public ExampleController(ExampleService service) {
        this.service = service;
    }


    @ApiOperation(value = "批量插入BatchSize为1", notes = "批量插入BatchSize为1(v1.0.0)")
    @PostMapping(value = "/inset/batch-one")
    public void insertOne() {
        service.saveBatchSizeOne();
    }

    @ApiOperation(value = "批量插入BatchSize为默认", notes = "批量插入BatchSize为默认(v1.0.0)")
    @PostMapping(value = "/inset/batch-default")
    public void insertDefault() {
        service.saveBatch();
    }

}