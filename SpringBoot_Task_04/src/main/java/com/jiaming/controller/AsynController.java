package com.jiaming.controller;

import com.jiaming.service.AsynService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmstart
 * @create 2020-05-27 13:04
 */
@RestController
public class AsynController {

    @Autowired
    private AsynService asynService;

    @GetMapping("/task01")
    public String task01() throws Exception {

        asynService.task01();

        return "success";
    }

}
