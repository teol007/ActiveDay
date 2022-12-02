package com.ActiveDay.ris.Repozitorij;

import com.ActiveDay.ris.Model.Vaja;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface VajaRepozitorij extends CrudRepository<Vaja, Long> {

    @Query(value="SELECT * FROM vaja v WHERE v.st_ponovitev<=?1 AND v.cas_trajanja<=?2", nativeQuery=true)
    List<Vaja> vrniVajeTezavnosti(int stPonovitev, long casTrajanja); //ta ?1 je za tocno prvi parameter

    @Query(value="SELECT * FROM vaja v WHERE v.naziv LIKE %?1% AND v.st_ponovitev<=?2 AND v.cas_trajanja<=?3", nativeQuery=true)
    List<Vaja> vrniDoloceneVajeTezavnosti(String priblizenNaziv, int stPonovitev, long casTrajanja);

}
