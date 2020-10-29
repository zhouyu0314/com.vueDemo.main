package com.zy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zy.entity.TestGen;
import com.zy.mapper.TestGenMapper;
import com.zy.service.TestGenService;
import com.zy.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestGenServiceImpl implements TestGenService {
    @Autowired(required = false)
    private TestGenMapper testGenMapper;

    @Override
    public TestGen getTestGenById(Long id) throws Exception {
        return null;
    }

    @Override
    public List<TestGen> getTestGenListByMap(Map<String, Object> param) throws Exception {
        return null;
    }

    @Override
    public Integer getTestGenCountByMap(Map<String, Object> param) throws Exception {
        return null;
    }

    @Override
    public Integer insertTestGen(TestGen testGen) throws Exception {
        return null;
    }

    @Override
    public Integer updateTestGen(TestGen testGen) throws Exception {
        return null;
    }

    @Override
    public Integer addList(HashMap param) throws Exception {

        //HasMap转换
        List<TestGen> list = JSONObject.parseArray(JSONObject.toJSONString(param.get("list"))).toJavaList(TestGen.class);

        for (TestGen testGen : list) {
            testGen.setId(IdWorker.getId());
        }
        Integer rows = testGenMapper.addList(list);
        System.out.println(rows);
        return null;
    }
}
