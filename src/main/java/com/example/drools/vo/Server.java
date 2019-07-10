package com.example.drools.vo;

/**
 * Created by zhuzs on 2017/7/21.
 */
public class Server {
    // 尝试次数
    private int times;

    public Server(int times) {
        this.times = times;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
