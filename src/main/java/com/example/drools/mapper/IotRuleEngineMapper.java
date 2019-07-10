package com.example.drools.mapper;

import com.example.drools.vo.IotRuleEngine;

import java.util.List;

public interface IotRuleEngineMapper {
    int deleteByPrimaryKey(Long iotengineRule);

    int insert(IotRuleEngine record);

    IotRuleEngine selectByPrimaryKey(Long iotengineRule);

    List<IotRuleEngine> selectAll();

    int updateByPrimaryKey(IotRuleEngine record);
}