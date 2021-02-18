package spring.bean.factory;

import ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link ioc.overview.domain.User} Bean 的 {@link org.springframework.beans.factory.FactoryBean} 实现
 *
 * @author: xiong
 * @create at 2021/2/8
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
