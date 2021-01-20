package ioc.overview.dependency.lookup;

import ioc.overview.annotation.Super;
import ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找
 * 1.通过名称的方式来查找
 * 2.通过类型来查找
 *
 * @author: xiong
 * @create at 2021/1/15
 */
public class DependencyLookupDemo {


    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup-context.xml");
        // 根据类型查找
        lookupByType(beanFactory);
        // 按照类型查找结合对象
        lookupCollectionByType(beanFactory);
        // 按照注解查找对象
        lookupByAnnotationType(beanFactory);

//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansWithAnnotation = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(" 查找到标注 @Super 所有的 User 集合对象 " + beansWithAnnotation);
        }
   }

    private static void lookupCollectionByType(BeanFactory beanFactory){
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(" 查找到的所有 User 集合对象 " + beansOfType.toString());
        }
    }

    private static void lookupByType(BeanFactory beanFactory){
        User bean = beanFactory.getBean(User.class);
        System.out.println(" 实时查找: " + bean);
    }

    private static void lookupInLazy(BeanFactory beanFactory){
        // Fac
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println(" 延迟查找: " + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println(" 实时查找: " + user);
    }

}
