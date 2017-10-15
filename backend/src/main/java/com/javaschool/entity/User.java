package com.javaschool.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Users", schema = "JVS")
public class User extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Ticket> tickets;


    public User(String name, String lastName, String email, String password, Date birthDate, boolean isAdmin) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.isAdmin = isAdmin;
    }
}
