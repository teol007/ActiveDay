package com.ActiveDay.ris.Model;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

//Vir: https://www.baeldung.com/role-and-privilege-for-spring-security-registration (11.12.2022
@Entity
public class Role {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<Uporabnik> uporabniki;

    @ManyToMany
    @JoinTable(
        name = "roles_privileges", 
        joinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(
          name = "privilege_id", referencedColumnName = "id"))
    private Collection<Privilege> privileges;

    public Role()
    {}

    public Role(String naziv)
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

    public void setUporabniki(Collection<Uporabnik> uporabniki) {
        this.uporabniki = uporabniki;
    }

    public Collection<Uporabnik> getUporabniki() {
        return uporabniki;
    }

    public void setPrivileges(Collection<Privilege> privileges) {
        this.privileges = privileges;
    }

    public Collection<Privilege> getPrivileges() {
        return privileges;
    }

}
