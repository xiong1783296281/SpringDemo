package ioc.overview.repository;

import ioc.overview.domain.User;

import java.util.Collection;

/**
 * @author: xiong
 * @create at 2021/1/20
 */
public class UserRepository {

    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
