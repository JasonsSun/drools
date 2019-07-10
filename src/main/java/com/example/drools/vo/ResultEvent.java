package com.example.drools.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuzs on 2017/7/21.
 */
public class ResultEvent {
    private List<String> events = new ArrayList<>();
//省略getter/setter方法

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }
}

