package org.example.repository.Repository;

import org.example.repository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserById(Integer id);
    List<User> findUserByEmail(String email);
    List<User> findUserByRole(String role);

    List<User> findUserByAge(Integer age);

    User findUserByUsernameAndPassword(String username , String password);
}
