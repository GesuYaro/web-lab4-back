package shagiev.weblab4back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import shagiev.weblab4back.beans.UserBean;

public interface UserDataRepository extends JpaRepository<UserBean, String> {

    UserBean findByUsername(String username);

}
