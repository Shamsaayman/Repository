package org.example.repository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "cannot be empty")
    private Integer id;
    @NotEmpty(message = "cannot be empty")
    @Size(min=5 , message = "mus be greater than 4 ")
    @Column(columnDefinition = "varchar(5) not null ")
    private String name;
    @NotEmpty(message = "cannot be empty")
    @Size(min=5 , message = "mus be greater than 4 ")
    @Column(columnDefinition = "varchar(5) not null unique ")
    private String username;
    @NotEmpty(message = "cannot be empty")
    @Column(columnDefinition = "varchar(5) not null ")
    private String password;
    @NotEmpty(message = "cannot be empty")
    @Email(message = "valid email")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String email;
    @NotEmpty(message = "cannot be empty")
    @Pattern(regexp = "^(user|admin)$")
    @Column(columnDefinition = "varchar(5) not null check(role='user' or role='admin')")
    private String role;
    @NotNull(message = "cannot be empty")
    @Column(columnDefinition = "int not null")
    private Integer age;

}
