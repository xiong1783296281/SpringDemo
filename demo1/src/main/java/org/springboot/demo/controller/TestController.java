package org.springboot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springboot.demo.bean.handler.ActionHandler;
import org.springboot.demo.bean.handler.ActionTypeJudger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {


    @GetMapping("/test")
    public String test(){
        ActionHandler action = ActionTypeJudger.valueOf("TEST").getAction();
        action.action();
        Map<String,String> map = new HashMap<String, String>();
        map.put("version","v1.0.1");
        return JSONObject.toJSONString(map);
    }

}
