package jpa.dao;

import jpa.entitymodels.Role;
import jpa.entitymodels.User;

import java.util.List;

public interface RoleDAO extends GenericDAO<Role> {
    void assignRoleToUser(Role role, User user);
    void assignRoleToUsers(Role role, List<User> users);
}
