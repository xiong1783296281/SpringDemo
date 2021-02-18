package spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * @author       : xiong
 * @Date         : 2021-02-09
 * @LastEditors  : xiong
 * @LastEditTime : 2021-02-09
 * @Description  : 
 */
public class BeanGarbageCollectionDemo {


    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册 Configuration Class(配置类)
        applicationContext.register(BeanInitializationDemo.class);
        // 启动 Spring 应用上下文
        applicationContext.refresh();
        
        // 关闭 Spring 应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭...");
        // 强制gc
        System.gc();
    }
    
}