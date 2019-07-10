package com.example.drools.service;

import com.example.drools.vo.IotRuleEngine;

import java.time.Instant;
import java.util.List;

public interface IotRuleEngineService {
    int deleteByPrimaryKey(Long iotengineRule);

    int insert(IotRuleEngine record);

    IotRuleEngine selectByPrimaryKey(Long iotengineRule);

    List<IotRuleEngine> selectAll();

    int updateByPrimaryKey(IotRuleEngine record);

    String ruleWorkMap(String name, Instant time);

}
