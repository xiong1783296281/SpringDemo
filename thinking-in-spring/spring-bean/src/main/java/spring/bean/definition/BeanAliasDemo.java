package spring.bean.definition;

import ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: xiong
 * @create at 2021/2/8
 */
public class BeanAliasDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        User xingxing = beanFactory.getBean("xingxing", User.class);
        User user = beanFactory.getBean("user", User.class);

        System.out.println(xingxing == user);

    }

}
