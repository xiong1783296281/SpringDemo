package org.xiong.test.configuration;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.client.config.NacosConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;
import java.util.concurrent.*;

/**
 * @author: xiong
 * @create at 2021/1/11
 */
@Slf4j
@Configuration
public class NacosConfiguration {

    @Autowired
    private NacosConfigProperties nacosConfig;
    private Properties properties;

    @Bean
    public NacosConfigService nacosConfigService() throws NacosException {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.NAMESPACE,nacosConfig.getNamespace());
        properties.setProperty(PropertyKeyConst.SERVER_ADDR,nacosConfig.getServerAddr());
        NacosConfigService nacosConfigService = new NacosConfigService(properties);
        nacosConfigService.addListener(nacosConfig.getName(), nacosConfig.getGroup(), new Listener() {

            final int proNum = Runtime.getRuntime().availableProcessors();
            final ExecutorService executor = new ThreadPoolExecutor(2, proNum,10, TimeUnit.SECONDS,
                    new ArrayBlockingQueue<Runnable>(1024));

            public Executor getExecutor() {
                return executor;
            }

            public void receiveConfigInfo(String s) {
                System.out.println("recieve: " + s);
            }
        });

        return nacosConfigService;
    }



}
