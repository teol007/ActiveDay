package com.ActiveDay.ris.Repozitorij;

import com.ActiveDay.ris.Model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjavaRepozitorij extends CrudRepository<Objava, Long> {
    
}
