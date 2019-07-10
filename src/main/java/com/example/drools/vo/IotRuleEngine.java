package com.example.drools.vo;

import java.io.Serializable;

public class IotRuleEngine implements Serializable {
    private Long iotengineRule;

    private String iotenginePackage;

    private String iotengineType;

    private String iotengineTypecontent;

    private String iotengineRulename;

    private String iotengineRuletype;

    private String iotengineRulecondition;

    private String iotengineRuleresult;

    private Integer iotengineIsvalid;

    private String iotengineDescription;

    private static final long serialVersionUID = 1L;

    public IotRuleEngine(Long iotengineRule, String iotenginePackage, String iotengineType, String iotengineTypecontent, String iotengineRulename, String iotengineRuletype, String iotengineRulecondition, String iotengineRuleresult, Integer iotengineIsvalid, String iotengineDescription) {
        this.iotengineRule = iotengineRule;
        this.iotenginePackage = iotenginePackage;
        this.iotengineType = iotengineType;
        this.iotengineTypecontent = iotengineTypecontent;
        this.iotengineRulename = iotengineRulename;
        this.iotengineRuletype = iotengineRuletype;
        this.iotengineRulecondition = iotengineRulecondition;
        this.iotengineRuleresult = iotengineRuleresult;
        this.iotengineIsvalid = iotengineIsvalid;
        this.iotengineDescription = iotengineDescription;
    }

    public IotRuleEngine() {
        super();
    }

    public Long getIotengineRule() {
        return iotengineRule;
    }

    public void setIotengineRule(Long iotengineRule) {
        this.iotengineRule = iotengineRule;
    }

    public String getIotenginePackage() {
        return iotenginePackage;
    }

    public void setIotenginePackage(String iotenginePackage) {
        this.iotenginePackage = iotenginePackage == null ? null : iotenginePackage.trim();
    }

    public String getIotengineType() {
        return iotengineType;
    }

    public void setIotengineType(String iotengineType) {
        this.iotengineType = iotengineType == null ? null : iotengineType.trim();
    }

    public String getIotengineTypecontent() {
        return iotengineTypecontent;
    }

    public void setIotengineTypecontent(String iotengineTypecontent) {
        this.iotengineTypecontent = iotengineTypecontent == null ? null : iotengineTypecontent.trim();
    }

    public String getIotengineRulename() {
        return iotengineRulename;
    }

    public void setIotengineRulename(String iotengineRulename) {
        this.iotengineRulename = iotengineRulename == null ? null : iotengineRulename.trim();
    }

    public String getIotengineRuletype() {
        return iotengineRuletype;
    }

    public void setIotengineRuletype(String iotengineRuletype) {
        this.iotengineRuletype = iotengineRuletype == null ? null : iotengineRuletype.trim();
    }

    public String getIotengineRulecondition() {
        return iotengineRulecondition;
    }

    public void setIotengineRulecondition(String iotengineRulecondition) {
        this.iotengineRulecondition = iotengineRulecondition == null ? null : iotengineRulecondition.trim();
    }

    public String getIotengineRuleresult() {
        return iotengineRuleresult;
    }

    public void setIotengineRuleresult(String iotengineRuleresult) {
        this.iotengineRuleresult = iotengineRuleresult == null ? null : iotengineRuleresult.trim();
    }

    public Integer getIotengineIsvalid() {
        return iotengineIsvalid;
    }

    public void setIotengineIsvalid(Integer iotengineIsvalid) {
        this.iotengineIsvalid = iotengineIsvalid;
    }

    public String getIotengineDescription() {
        return iotengineDescription;
    }

    public void setIotengineDescription(String iotengineDescription) {
        this.iotengineDescription = iotengineDescription == null ? null : iotengineDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", iotengineRule=").append(iotengineRule);
        sb.append(", iotenginePackage=").append(iotenginePackage);
        sb.append(", iotengineType=").append(iotengineType);
        sb.append(", iotengineTypecontent=").append(iotengineTypecontent);
        sb.append(", iotengineRulename=").append(iotengineRulename);
        sb.append(", iotengineRuletype=").append(iotengineRuletype);
        sb.append(", iotengineRulecondition=").append(iotengineRulecondition);
        sb.append(", iotengineRuleresult=").append(iotengineRuleresult);
        sb.append(", iotengineIsvalid=").append(iotengineIsvalid);
        sb.append(", iotengineDescription=").append(iotengineDescription);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}