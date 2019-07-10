package com.example.drools.vo;

import java.time.Duration;
import java.time.Instant;


public class TimeResult {

    public  Instant Timess=null;

    public  Integer count=0;

    public Boolean status=true;

    public Boolean flag = false;

    public TimeResult() {
     super();
    }


    public TimeResult(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Instant getTimess() {
        return Timess;
    }

    public void setTimess(Instant timess) {
        Timess = timess;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Long getTimeSeconed(Instant time)
    {
      Long r=  Duration.between(Timess, time).getSeconds();
      return  r;
    }
}
