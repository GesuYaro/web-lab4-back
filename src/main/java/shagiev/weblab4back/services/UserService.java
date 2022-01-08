package shagiev.weblab4back.services;

import shagiev.weblab4back.beans.UserBean;

import java.util.List;

public interface UserService {

    UserBean saveUser(UserBean user);
    UserBean getUser(String username);
    List<UserBean> getAllUsers();

}
