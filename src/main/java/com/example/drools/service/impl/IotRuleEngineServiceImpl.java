package com.example.drools.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.drools.mapper.IotRuleEngineMapper;
import com.example.drools.service.IotRuleEngineService;
import com.example.drools.vo.IotRuleEngine;
import com.mseap.framework.dac.annotation.DataAccessResource;
import com.mseap.framework.dac.annotation.DataAccessSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@DataAccessSupport
@Transactional
public class IotRuleEngineServiceImpl implements IotRuleEngineService {


    @Autowired
    private IotRuleEngineMapper iotRuleEngineMapper;

    private Map<String, IotRuleEngine> promoteExecuteMap;

    @Override
    public int deleteByPrimaryKey(Long iotengineRule) {
        return iotRuleEngineMapper.deleteByPrimaryKey(iotengineRule);
    }

    @Override
    public int insert(IotRuleEngine record) {
        return iotRuleEngineMapper.insert(record);
    }

    @Override
    public IotRuleEngine selectByPrimaryKey(Long iotengineRule) {
        return iotRuleEngineMapper.selectByPrimaryKey(iotengineRule);
    }

    @Override
    public List<IotRuleEngine> selectAll() {
        return iotRuleEngineMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(IotRuleEngine record) {
        return iotRuleEngineMapper.updateByPrimaryKey(record);
    }

    /**
     * 组合业务规则Json方法
     *
     * @return 结果
     */
    public String ruleWorkMap(String name, Instant time) {
        Map<String, Object> map = new HashMap<String, Object>();
        //组合Rule部分
        Map<String, Object> rule = new HashMap<String, Object>();
        rule.put("name", name);
        map.put("rule", rule);
        //组合 规则When部分
        Map<String, Object> when = new HashMap<String, Object>();
        when.put("time", time);
        map.put("condition", when);

        //组合 规则Then部分
        Map<String, Object> then = new HashMap<String, Object>();
//        then.put("money", money);
        then.put("time", time);
        map.put("action", then);
        //组合规则When And Then 部分
        return JSONObject.toJSONString(map);
    }
}
