package com.jwt.jwt.Models;


import com.jwt.jwt.Task.Task;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String username ;
    @Column(name="password")
    private String password ;
    @Column(name="email")
    private String email ;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL)
    private List<Task> tasks ;

}
