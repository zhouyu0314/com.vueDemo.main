package com.zy.service;

import com.zy.entity.TestGen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface TestGenService {
    TestGen getTestGenById(Long id)throws Exception;

    List<TestGen> getTestGenListByMap(Map<String, Object> param)throws Exception;

    Integer getTestGenCountByMap(Map<String, Object> param)throws Exception;

    Integer insertTestGen(TestGen testGen)throws Exception;

    Integer updateTestGen(TestGen testGen)throws Exception;

    Integer addList(HashMap param)throws Exception;
}
