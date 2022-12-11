package com.ActiveDay.ris.Repozitorij;

import com.ActiveDay.ris.Model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VadbaRepozitorij extends CrudRepository<Vadba, Long> {

    //testni SQL stavek - vrne samo vadbo in stevilo vaj, ki jih ima: SELECT vad.*, COUNT(vaj.id) AS stVaj FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING stVaj>=?1 ;
    //testni SQL stavek - vrne vadbe z njihovimi vajami: SELECT vad.*, vaj.* FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id WHERE vad.id IN(SELECT id FROM (SELECT vad.*, COUNT(vaj.id) AS stVaj FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING stVaj>=?1 ) t1);
    //testni SQL stavek - vrne samo id vadb: SELECT vad.id FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>=?1 ;
    @Query(value="SELECT vad.id FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>=?1 ;", nativeQuery=true)
    List<Long> vrniVadbeZVecVajamiOd(int stVaj);

    //testni SQL stavek - vrne samo vadbo in stevilo vaj, ki jih ima: SELECT vad.*, COUNT(vaj.id) AS stVaj FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING stVaj<=?1 ;
    //testni SQL stavek - vrne vadbe z njihovimi vajami: SELECT vad.*, vaj.* FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id WHERE vad.id IN(SELECT id FROM (SELECT vad.*, COUNT(vaj.id) AS stVaj FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING stVaj<=?1 ) t1);
    //testni SQL stavek - vrne samo id vadb: SELECT vad.id FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>=?1 ;
    @Query(value="SELECT vad.id FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)<=?1 ;", nativeQuery=true)
    List<Long> vrniVadbeZManjVajamiOd(int maxStVaj);

}
