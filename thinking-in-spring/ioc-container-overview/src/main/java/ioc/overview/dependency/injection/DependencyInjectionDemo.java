package ioc.overview.dependency.injection;

import ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

/**
 * 依赖注入示例
 *
 * @author: xiong
 * @create at 2021/1/20
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {

//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");

        // 依赖来源一： 自定义 Bean
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);

        whoIsIocContainer(beanFactory,userRepository);
//        System.out.println(userRepository.getUsers());

        // 依赖来源二： 依赖注入(内建依赖)
        System.out.println(userRepository.getBeanFactory());
//        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();

        System.out.println(objectFactory.getObject() == beanFactory);

        // 依赖查找（错误示例）
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        // 依赖来源三： 容器内建 Bean
        Environment environment = beanFactory.getBean(Environment.class);
        System.out.println(" 获取Enviroment 类型的Bean " + environment);

    }

    private static void whoIsIocContainer( ApplicationContext beanFactory, UserRepository userRepository){

        System.out.println(" 看看是不是相等 " + (userRepository.getBeanFactory() == beanFactory));

        // ApplicationContext is BeanFactory

    }

}
