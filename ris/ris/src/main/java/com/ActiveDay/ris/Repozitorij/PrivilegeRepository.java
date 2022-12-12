package com.ActiveDay.ris.Repozitorij;

import com.ActiveDay.ris.Model.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
    @Query(value="SELECT * FROM privilege p WHERE p.naziv LIKE ?1 LIMIT 1", nativeQuery=true)
    Privilege findByName(String naziv);
}
