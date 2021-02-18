package spring.bean.factory;

import ioc.overview.domain.User;

/**
 * {@link UserFactory} 工厂类
 *
 * @author: xiong
 * @create at 2021/2/8
 */
public interface UserFactory {

    default User createUser(){
        return User.createUser();
    }

}
