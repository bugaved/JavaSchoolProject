package com.javaschool.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Represents a user of our website.
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "Users", schema = "JVS")
public class User extends BaseEntity {
    /**
     * first name of the user
     */
    @Column(name = "name")
    private String name;
    /**
     *  last name of the user
     */
    @Column(name = "last_name")
    private String lastName;
    /**
     * email of the user
     */
    @Column(name = "email")
    private String email;
    /**
     * password of the user
     */
    @Column(name = "password")
    private String password;
    /**
     * birthdate of the user
     */
    @Column(name = "birth_date")
    private Date birthDate;
    /**
     * boolean that shows that user is admin or not
     */
    @Column(name = "is_admin")
    private boolean isAdmin;
    /**
     * Tickets of the user
     */
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
