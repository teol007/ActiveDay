package com.ActiveDay.ris.Repozitorij;

import com.ActiveDay.ris.Model.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Query(value="SELECT * FROM role r WHERE r.naziv LIKE ?1 LIMIT 1", nativeQuery=true)
    Role findByName(String naziv);

}
