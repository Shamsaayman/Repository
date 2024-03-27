package org.example.repository.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.repository.API.ApiResponse;
import org.example.repository.Model.User;
import org.example.repository.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("user added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("user updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("user deleted"));
    }


    @GetMapping("/getuserpass/{username}/{password}")
    public ResponseEntity findByUsernamePassword(@PathVariable String username, @PathVariable String password) {
        return ResponseEntity.status(200).body(userService.findByUsernameAndPassword(username,password));
    }

    @GetMapping("/getuserpass/{email}")
    public ResponseEntity findByEmail(@PathVariable String email) {
        return ResponseEntity.status(200).body(userService.getEmail(email));
    }
    @GetMapping("/getuserpass/{role}")
    public ResponseEntity findByRole(@PathVariable String role) {
        return ResponseEntity.status(200).body(userService.getRole(role));
    }
    @GetMapping("/getuserpass/{age}")
    public ResponseEntity findByUsernamePassword(@PathVariable Integer age) {
        return ResponseEntity.status(200).body(userService.getAge(age));
    }


    }