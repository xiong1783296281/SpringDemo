package org.springboot.demo.bean.handler;

import org.springboot.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestActionHandler implements ActionHandler{

    private static TestActionHandler handler;

    @Autowired
    TestService testService;

    public void action() {
        handler.testService.test();
    }

    @PostConstruct
    public void init(){
        handler = this;
        handler.testService = this.testService;
    }
}
