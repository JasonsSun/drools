package com.example.drools.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.drools.Drools.RuleCreate;
import com.example.drools.Drools.getNewData;
import com.example.drools.service.IotRuleEngineService;
import com.example.drools.vo.AlarmInfo;
import com.example.drools.vo.IotRuleEngine;
import com.example.drools.vo.Result;
import com.example.drools.vo.TimeResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.time.Instant;

import static com.example.drools.Drools.RuleExecute.Ruleexecute;
import static com.example.drools.Drools.RuleExecute2.Ruleexecute2;

@Controller
@RequestMapping(value = "/rule")
public class iotRuleController {


    @Autowired
    private IotRuleEngineService iotRuleEngineService;

    @ApiOperation("加入规则引擎信息")
    @RequestMapping(value = "/insertIotEngine")
    @ResponseBody
    public Result insertioIotEngineInformation() {

        Result result = new Result();
        IotRuleEngine iotRuleEngine = new IotRuleEngine();
        iotRuleEngine.setIotenginePackage("package com.w.iot;");
        iotRuleEngine.setIotengineTypecontent("import java.text.SimpleDateFormat;\n\timport java.util.Date;\n\tglobal java.text.SimpleDateFormat fmt; ");
        iotRuleEngine.setIotengineRulename("timers");
        iotRuleEngine.setIotengineRuletype("timer(cron: */1 * * * * ?)");
        iotRuleEngine.setIotengineIsvalid(1);
        iotRuleEngine.setIotengineRulecondition("eval(true)");
        iotRuleEngine.setIotengineRuleresult(" System.out.println(fmt.format(new Date()));");
        TimeResult n = new TimeResult();
        iotRuleEngine.setIotengineDescription(RuleCreate.rule(iotRuleEngine));
        iotRuleEngineService.insert(iotRuleEngine);
        result.setSuccess(true);
        result.setMsg("信息插入成功");
        return result;
    }


    @ApiOperation("运行规则引擎")
    @RequestMapping(value = "/executeIotEngine")
    @ResponseBody
    public Result executeIotEngine() {

        Result result = new Result();

        IotRuleEngine iotRuleEngineList = iotRuleEngineService.selectByPrimaryKey((long) 29);
//        for (IotRuleEngine e:iotRuleEngineList
//        ) {
//            rules.add(e.getIotengineDescription());
//        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//        TimeResult timeResult=new TimeResult();
//        timeResult.setTimelimit(Instant.now());
//        Ruleexecute(iotRuleEngineList.getIotengineDescription(), simpleDateFormat);
        result.setSuccess(true);
        result.setMsg("开始运行");
        return result;
    }

    @ApiOperation("加入规则引擎信息")
    @RequestMapping(value = "/insertIotEngines")
    @ResponseBody
    public Result insertioIotEngineInformations() {

        Result result = new Result();
        IotRuleEngine iotRuleEngine = new IotRuleEngine();
        iotRuleEngine.setIotenginePackage("package com.example.drools;");
        iotRuleEngine.setIotengineTypecontent("import java.text.SimpleDateFormat;\n\timport java.util.Date;\n\timport com.example.drools.vo.TimeResult;");
        iotRuleEngine.setIotengineRulename("iwant");
        iotRuleEngine.setIotengineRuletype("timer(cron: */1 * * * * ?)");
        iotRuleEngine.setIotengineIsvalid(1);
        iotRuleEngine.setIotengineRulecondition("$t:TimeResult( status == false  &&  count < 6 )");
        iotRuleEngine.setIotengineRuleresult("if($t.getCount()<=6){" +
                " $t.setCount($t.getCount()+1);" +
                "update($t);" +
                "System.out.println($t.getCount()) ;");
        TimeResult n = new TimeResult();
        iotRuleEngine.setIotengineDescription(RuleCreate.rule(iotRuleEngine));
        iotRuleEngineService.insert(iotRuleEngine);

        result.setSuccess(true);
        result.setMsg("信息插入成功");
        return result;
    }

    @ApiOperation("执行运行规则引擎")
    @RequestMapping(value = "/executeIotEngines")
    @ResponseBody
    public TimeResult executeIotEngines(TimeResult timeResult) {

        Result result = new Result();
        IotRuleEngine iotRuleEngineList = iotRuleEngineService.selectByPrimaryKey((long) 38);
//        TimeResult timeResult=new TimeResult();
//        timeResult.setStatus(false);
//        timeResult.setCount(0);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Ruleexecute(iotRuleEngineList.getIotengineDescription(), timeResult);
        result.setSuccess(true);
        result.setMsg("开始运行");
        return timeResult;
    }

    @ApiOperation("加入规则状态改变信息")
    @RequestMapping(value = "/insertIotEngines1")
    @ResponseBody
    public Result insertioIotEngineInformations1() {

        Result result = new Result();
        IotRuleEngine iotRuleEngine = new IotRuleEngine();
        iotRuleEngine.setIotenginePackage("package com.example.drools;");
        iotRuleEngine.setIotengineTypecontent("import java.text.SimpleDateFormat;\n\timport java.util.Date;\n\timport com.example.drools.vo.TimeResult;");
        iotRuleEngine.setIotengineRulename("iwant1");
        iotRuleEngine.setIotengineRuletype("no-loop true");
        iotRuleEngine.setIotengineIsvalid(1);
        iotRuleEngine.setIotengineRulecondition("$t:TimeResult( status == false)");
        iotRuleEngine.setIotengineRuleresult("$t.setStatus(true);" +
                "update($t);" +
                "System.out.println($t.getStatus()) ;");
        TimeResult n = new TimeResult();
        iotRuleEngine.setIotengineDescription(RuleCreate.rule(iotRuleEngine));
        iotRuleEngineService.insert(iotRuleEngine);
        result.setSuccess(true);
        result.setMsg("信息插入成功");
        return result;
    }
    @ApiOperation("执行运行规则引擎")
    @RequestMapping(value = "/executeIotEngines1")
    @ResponseBody
    public TimeResult executeIotEngines1(TimeResult timeResult) {

        Result result = new Result();
        StringBuffer stringBuffer=new StringBuffer();

        IotRuleEngine iotRuleEngineList1 = iotRuleEngineService.selectByPrimaryKey((long) 38);
        IotRuleEngine iotRuleEngineList2 = iotRuleEngineService.selectByPrimaryKey((long) 39);
        IotRuleEngine iotRuleEngineList3 = iotRuleEngineService.selectByPrimaryKey((long) 41);
//        IotRuleEngine iotRuleEngineList4 = iotRuleEngineService.selectByPrimaryKey((long) 42);
        stringBuffer.append(iotRuleEngineList1.getIotengineDescription());
        stringBuffer.append(iotRuleEngineList2.getIotengineDescription());
        stringBuffer.append(iotRuleEngineList3.getIotengineDescription());
//        stringBuffer.append(iotRuleEngineList4.getIotengineDescription());

//        TimeResult timeResult=new TimeResult();
//        timeResult.setStatus(false);
//        timeResult.setCount(0);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Ruleexecute(stringBuffer, timeResult);

        executeIotEngines(timeResult);
        result.setSuccess(true);
        result.setMsg("开始运行");
        return timeResult;
    }
    @ApiOperation("执行运行规则引擎")
    @RequestMapping(value = "/getNewData")
    @ResponseBody
    public TimeResult getNewDatas(TimeResult timeResult) {
        getNewData get=new getNewData(timeResult);

        return get.getTimeResult();

    }

    @ApiOperation("执行运行规则引擎")
    @RequestMapping(value = "/executeIotEngines2")
    @ResponseBody
    public AlarmInfo executeIotEngines2(String data) {

        String datas=data;
        System.out.println(datas);
        Result result = new Result();
        AlarmInfo alarmInfo=new AlarmInfo();
        StringBuffer stringBuffer=new StringBuffer();
        JSONObject jobject = JSON.parseObject(datas);
        JSONObject jobjectalarm = JSON.parseObject(jobject.getString("alarm"));
        JSONObject jobjectErrorCode = JSON.parseObject(jobject.getString("ErrorCode"));
        JSONObject jobjectbattery = JSON.parseObject(jobject.getString("battery"));
        JSONObject jobjectdevID = JSON.parseObject(jobject.getString("devID"));
        JSONObject jobjectmove = JSON.parseObject(jobject.getString("move"));


        alarmInfo.setAlarm(jobjectalarm.getString("value"));
        alarmInfo.setErrorCode(jobjectErrorCode.getString("value"));
        alarmInfo.setBattery(jobjectbattery.getString("value"));
        alarmInfo.setDevID(jobjectdevID.getString("value"));
        alarmInfo.setMove(jobjectmove.getString("value"));
        alarmInfo.setDevice_id(jobject.getString("device_id"));
        alarmInfo.setCount(0);


        IotRuleEngine iotRuleEngineList1 = iotRuleEngineService.selectByPrimaryKey((long) 43);
        IotRuleEngine iotRuleEngineList2 = iotRuleEngineService.selectByPrimaryKey((long) 44);
        IotRuleEngine iotRuleEngineList3 = iotRuleEngineService.selectByPrimaryKey((long) 45);
        IotRuleEngine iotRuleEngineList4 = iotRuleEngineService.selectByPrimaryKey((long) 46);
        stringBuffer.append(iotRuleEngineList1.getIotengineDescription());
        stringBuffer.append(iotRuleEngineList2.getIotengineDescription());
        stringBuffer.append(iotRuleEngineList3.getIotengineDescription());
        stringBuffer.append(iotRuleEngineList4.getIotengineDescription());

//        TimeResult timeResult=new TimeResult();
//        timeResult.setStatus(false);
//        timeResult.setCount(0);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Ruleexecute2(stringBuffer, alarmInfo);


        result.setSuccess(true);
        result.setMsg("开始运行");
        return alarmInfo;
    }

}
