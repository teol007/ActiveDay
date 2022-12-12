package com.ActiveDay.ris.Model;

import java.util.Collection;
import jakarta.persistence.*;

//Vir: https://www.baeldung.com/role-and-privilege-for-spring-security-registration (11.12.2022)
@Entity
public class Privilege {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    public Privilege(String naziv)
    {
        this.naziv = naziv;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Role> getRoles() {
        return roles;
    }
}