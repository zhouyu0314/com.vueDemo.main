package com.zy.controller;

import com.zy.dto.Dto;
import com.zy.service.TestGenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/test")
@CrossOrigin
public class TestGenController {
    @Autowired
    private TestGenService testGenService;

    @PostMapping("/addList")
    public Dto addList(@RequestBody HashMap param) throws Exception {

        testGenService.addList(param);
        return null;

    }
}
