package jpa.dao;

import jpa.entitymodels.Role;
import jpa.entitymodels.User;

import java.util.List;

public interface UserDAO extends GenericDAO<User> {
    //UserEntity findById(int id);
    //void updateDatabase(UserEntity entity);
    User findByEmail(String email);
    List<User> findByRole(Role role);
}
