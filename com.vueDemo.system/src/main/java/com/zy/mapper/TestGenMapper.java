package com.zy.mapper;
import com.zy.entity.TestGen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestGenMapper {

	public TestGen getTestGenById(@Param(value = "id") Long id)throws Exception;

	public List<TestGen>	getTestGenListByMap(Map<String, Object> param)throws Exception;

	public Integer getTestGenCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertTestGen(TestGen testGen)throws Exception;

	public Integer updateTestGen(TestGen testGen)throws Exception;

	//*************插入集合******************

	Integer addList(List<TestGen> testGens)throws Exception;


}
