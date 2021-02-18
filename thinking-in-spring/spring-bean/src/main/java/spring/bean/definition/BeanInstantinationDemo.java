package spring.bean.definition;

import ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 实例示例化
 *
 * @author: xiong
 * @create at 2021/2/8
 */
public class BeanInstantinationDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User instanceUser = beanFactory.getBean("user-by-instance-method", User.class);
        User userFactoryBean = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);
        System.out.println(instanceUser);
        System.out.println(userFactoryBean);

        System.out.println(user == instanceUser);
        System.out.println(user == userFactoryBean);
    }

}
