package com.example.drools.Drools;

import com.example.drools.service.IotRuleEngineService;
import com.example.drools.vo.IotRuleEngine;
import com.example.drools.vo.Result;
import com.example.drools.vo.TimeResult;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.TimedRuleExecutionOption;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.builder.*;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Component
public class RuleExecute {
    private static SimpleDateFormat fmt;
    private static final Logger logger = LoggerFactory.getLogger(RuleExecute.class);


   public  static HashMap<String,KieSession> sessionHashMap=new HashMap<>();
    public  static HashMap<String,TimeResult> timeResultHashMap=new HashMap<>();
    @Autowired
    private IotRuleEngineService iotRuleEngineService;

    //   public static KnowledgeBuilderConfiguration config = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();
//   public static  KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(config);
//   public static  KieBase kieBase = kbuilder.newKieBase();
//   public static  KieSession kSessions  = null;
    private void GetAllRules() {
//        List<String,String>  rules=new ArrayList<String,String>();
        List<IotRuleEngine> iotRuleEngineList = iotRuleEngineService.selectAll();
        for (IotRuleEngine e : iotRuleEngineList
        ) {
//            Ruleexecute(e.getIotengineDescription());
        }


    }

    public static Result Ruleexecute(StringBuffer rule, TimeResult t) {
        KieSession kSession = null;
        if (sessionHashMap.get("timer") != null) {
            kSession = sessionHashMap.get("timer");
            TimeResult timeResult = timeResultHashMap.get("timeresult");
            timeResult.status = t.status;
            FactHandle faceHandle = kSession.insert(timeResult);
            kSession.update(faceHandle, timeResult);
            kSession.setGlobal("session", kSession);
            //触发rules
            int count = kSession.fireAllRules();
//            kSession.fireUntilHalt();
        } else {
            try {
                // 从数据库根据code查规则
                KnowledgeBuilderConfiguration config = KnowledgeBuilderFactory.newKnowledgeBuilderConfiguration();

                KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder(config);

                KnowledgeBuilderErrors errors = kbuilder.getErrors();
                for (KnowledgeBuilderError error : errors) {
                    logger.error("规则文件正确性有误：{}", error);
                    return Result.buildFail(null, "规则文件正确性有误");
                }
                System.out.println(rule);
                kbuilder.add(ResourceFactory.newByteArrayResource(rule.toString().getBytes("utf-8")), ResourceType.DRL);

                KieBase kieBase = kbuilder.newKieBase();

                // 检查规则正确性
                KieSessionConfiguration ksconf = KieServices.Factory.get().newKieSessionConfiguration();
                ksconf.setOption(TimedRuleExecutionOption.YES);
                kSession = kieBase.newKieSession(ksconf, null);


                FactHandle faceHandle = kSession.insert(t);
                sessionHashMap.put("timer",kSession);
                timeResultHashMap.put("timeresult",t);

                kSession.setGlobal("session", kSession);
                //触发rules
                kSession.fireUntilHalt();

                int count = kSession.fireAllRules();

            } catch (Exception e) {
                logger.error("规则执行异常：{}", e);
            } finally {
                if (null != kSession)
                    kSession.halt();
                    kSession.dispose();
            }
            return Result.buildSuccess(kSession, "规则已经执行");
        }
        return Result.buildSuccess(kSession, "规则已经执行");
    }

}
