package com.spring.security.demospringsecurity.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Mehran on 7/17/2023
 */
@Setter
@Getter
@Entity
@Table(name = "role")
@SequenceGenerator(name = "sequence_db", sequenceName = "SEQ_Role", allocationSize = 1)

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
