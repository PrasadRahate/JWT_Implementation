package com.jwt.jwt.Task;

import com.jwt.jwt.Models.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tasks")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id ;
    @Column(name="title")
    private String title ;
    @Column(name="description")
    private String description ;
    @Column(name = "status")
    private String status ;

    private String createdby ;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user ;
}
