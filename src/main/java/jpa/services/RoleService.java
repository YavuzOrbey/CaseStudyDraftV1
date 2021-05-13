package jpa.services;

import jpa.dao.RoleDAO;
import jpa.entitymodels.Role;
import jpa.entitymodels.User;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleService implements RoleDAO {
    @Override
    public Role findById(int id) {
        Role role =  entityManager.find(Role.class, id);
        return role;
    }

    @Override
    public  List<Role> findAll() {
        Query q = entityManager.createQuery("SELECT r FROM Role r");
        return (List<Role>) q.getResultList();
    }

    @Override
    public void assignRoleToUsers(Role role, List<User> users) {
         entityManager.getTransaction().begin();
          role.setUsers(users);
          entityManager.getTransaction().commit();

//        UserService userService = new UserService();
////        for (User user: users) {
////            List<Role> roles = user.getRoles();
////            System.out.println(user.getEmail() + " is a " + user.getRoles());
////            roles.add(role);
////            System.out.println(user.getEmail() + " is a " + user.getRoles());
////        }
    }

    @Override
    public void assignRoleToUser(Role role, User user){
        entityManager.getTransaction().begin();
        role.getUsers().add(user);
        entityManager.getTransaction().commit();
    }
}
