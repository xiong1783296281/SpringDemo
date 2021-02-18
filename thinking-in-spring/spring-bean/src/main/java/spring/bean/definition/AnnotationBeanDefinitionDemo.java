package spring.bean.definition;

import ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @author: xiong
 * @create at 2021/2/8
 */
// 3.通过 @import 来进行导入
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {

    public static void main(String[] args) {

        // 创建 BeanFactory
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //注册 Configuration Class(配置类)
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        registerBeanDefinition(applicationContext,"mercyblitz-user", User.class);
        registerBeanDefinition(applicationContext,"", User.class);

        applicationContext.refresh();
        System.out.println("Config maps: " + applicationContext.getBeansOfType(Config.class));
        System.out.println("User maps: " + applicationContext.getBeansOfType(User.class));

        // 显示的关闭 Spring 应用上下文
        applicationContext.close();

    }

    // region 命名 Bean 的注册方式
    public static void registerBeanDefinition(BeanDefinitionRegistry registry, Class<?> beanClass){
        registerBeanDefinition(registry,null,beanClass);
    }

    public static void registerBeanDefinition(BeanDefinitionRegistry registry, String beanName, Class<?> beanClass){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(beanClass);
        beanDefinitionBuilder.addPropertyValue("id",2L)
                .addPropertyValue("name","...");

        if (StringUtils.hasText(beanName)){
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        }else{
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }

    }
    // endregion

    // 2.通过 @Component 方式
    @Component
    public static class Config{

        // 1.通过 @Bean 方式定义
        @Bean(name={"user","xingxing"})
        public User user(){
            User user = new User();
            user.setId(1L);
            user.setName("lalala");
            return user;
        }
    }

}
