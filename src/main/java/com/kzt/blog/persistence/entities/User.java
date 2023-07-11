package com.kzt.blog.persistence.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;

import com.kzt.blog.bl.dto.user.UserDTO;
import com.kzt.blog.web.forms.UserForm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(
    		name= "users_roles",
    		joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
    		inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    	super();
    	this.roles = new HashSet<>();
    }
   
    public User(UserForm userForm) {
    	this.id = userForm.getId();
    	this.name = userForm.getName();
    	this.email = userForm.getEmail();
    	this.password = userForm.getPassword();
    }
    
    public User(UserDTO userDto) {
    	this.id = userDto.getId();
    	this.name = userDto.getName();
    	this.email = userDto.getEmail();
    	this.password = userDto.getPassword();
    }
}
