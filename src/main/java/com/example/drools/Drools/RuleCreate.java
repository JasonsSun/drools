package com.example.drools.Drools;

import com.alibaba.fastjson.JSONObject;
import com.example.drools.vo.IotRuleEngine;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupString;

import static com.example.drools.Drools.TimerTemplate.workTimerST;

public class RuleCreate {

    public static String rule(IotRuleEngine iotRuleEngine) {
//        String rule = ruleWordExchangsST(iotRuleEngine,json);
        String rule=GenerateTempLate(iotRuleEngine);
        return rule;
    }

    /**
     * 规则业务生成
     */
    public static String ruleWordExchangsST(IotRuleEngine iotRuleEngine,String json) {
        String s=GenerateTempLate(iotRuleEngine);
        STGroup group = new STGroupString(s);
        ST stFile = group.getInstanceOf("wordImport");
        ST stRule = group.getInstanceOf("ruleValue");
        JSONObject jsonObject = JSONObject.parseObject(json);
        JSONObject condition = jsonObject.getJSONObject("condition");
        JSONObject action = jsonObject.getJSONObject("action");
        JSONObject rule = jsonObject.getJSONObject("rule");
        stRule.add("condition", condition);
        stRule.add("action", action);
        stRule.add("rule", rule);
        stFile.add("rules", stRule);
        String result = stFile.render();
        return result;
    }

    public static  String  GenerateTempLate(IotRuleEngine iotRuleEngine)
    {
        String workTimerST="";
        if(null!=iotRuleEngine) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\t"+iotRuleEngine.getIotenginePackage()+"\n");
            stringBuilder.append("\n");
            stringBuilder.append("\t"+iotRuleEngine.getIotengineTypecontent()+"\n");
            stringBuilder.append("\n");
            stringBuilder.append("rule \""+iotRuleEngine.getIotengineRulename()+"\"\n");
            stringBuilder.append("\t\t"+iotRuleEngine.getIotengineRuletype()+"\n");
            stringBuilder.append("\t\twhen\n");
            stringBuilder.append("\t\t "+iotRuleEngine.getIotengineRulecondition()+"\n");
            stringBuilder.append(" \t\tthen\n");
            stringBuilder.append("      \t  "+iotRuleEngine.getIotengineRuleresult()+ "\n");
            stringBuilder.append("end\n");
            workTimerST = stringBuilder.toString();
        }
        return workTimerST ;

    }
}
