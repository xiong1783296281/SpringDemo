package org.springboot.demo.service.impl;

import org.springboot.demo.service.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {

    public void test() {
        System.out.println("only test");
    }
}
