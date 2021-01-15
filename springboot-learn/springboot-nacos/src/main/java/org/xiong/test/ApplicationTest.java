package org.xiong.test;

import com.alibaba.cloud.nacos.NacosConfigAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;

/**
 * @author: xiong
 * @create at 2021/1/11
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationTest.class);
        Iterator<String> beanNamesIterator = context.getBeanFactory().getBeanNamesIterator();
        while (beanNamesIterator.hasNext()){
            System.out.println(beanNamesIterator.next());
        }
    }

}
