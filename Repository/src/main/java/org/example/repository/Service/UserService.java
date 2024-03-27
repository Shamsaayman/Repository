package org.example.repository.Service;

import lombok.RequiredArgsConstructor;
import org.example.repository.API.ApiException;
import org.example.repository.Model.User;
import org.example.repository.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(User user){
    userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User u = userRepository.findUserById(id);
        if(u==null){
            throw new ApiException("Invalid id");
        }
        userRepository.delete(u);
    }

    public void updateUser(Integer id , User user){
        User u = userRepository.findUserById(id);
        if(u==null){
            throw new ApiException("Invalid id");
        }
        u.setName(user.getName());
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setAge(user.getAge());
        userRepository.save(u);
    }


    public User findByUsernameAndPassword(String username , String password){
        User u = userRepository.findUserByUsernameAndPassword(username, password);
        if(u==null){
            throw new ApiException("Invalid id");
        }
        return u;
    }

    public List<User> getEmail(String email){
        List<User>users = userRepository.findUserByEmail(email);
        if(users==null){
            throw new ApiException("Invalid email");
        }
        return users;
    }

    public List<User> getRole(String role){
        List<User>users = userRepository.findUserByRole(role);
        if(users==null){
            throw new ApiException("Invalid role");
        }
        return users;
    }

    public List<User> getAge(Integer age){
        List<User>users = userRepository.findUserByAge(age);
        if(users==null){
            throw new ApiException("Invalid age");
        }
        return users;
    }
}
