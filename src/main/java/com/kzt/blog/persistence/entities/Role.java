package com.kzt.blog.persistence.entities;

import java.util.Set;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> users;
    
    public Role() {
    	super();
    }
}
