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
    @Query(value="SELECT vad.id FROM vadba vad LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>=?1 ;", nativeQuery=true)
    List<Long> vrniVadbeZVecVajamiOd(int stVaj);

    //testni SQL stavek - vrne samo vadbo in stevilo vaj, ki jih ima: SELECT vad.*, COUNT(vaj.id) AS stVaj FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING stVaj<=?1 ;
    //testni SQL stavek - vrne vadbe z njihovimi vajami: SELECT vad.*, vaj.* FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id WHERE vad.id IN(SELECT id FROM (SELECT vad.*, COUNT(vaj.id) AS stVaj FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING stVaj<=?1 ) t1);
    //testni SQL stavek - vrne samo id vadb: SELECT vad.id FROM vadba vad INNER JOIN vadba_vaje vv ON vv.vadba_id = vad.id INNER JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>=?1 ;
    @Query(value="SELECT vad.id FROM vadba vad LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)<= ?1 ;", nativeQuery=true)
    List<Long> vrniVadbeZManjVajamiOd(int maxStVaj);

    //SQL stavek: SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>=2 ) AND vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING COUNT(o.id)>=4 );
    @Query(value="SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>= ?1 ) AND vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING COUNT(o.id)>= ?2 );", nativeQuery=true)
    List<Long> vrniVadbeZVecVajamiOdZVecOcenOd(int minStVaj, int minStOcen);

    //SQL stavek: SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)<=1 ) AND vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING COUNT(o.id)<=3 );
    @Query(value="SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id  LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)<= ?1 ) AND vad.id IN( SELECT vad.id FROM vadba vad  LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING COUNT(o.id)<= ?2 );", nativeQuery=true)
    List<Long> vrniVadbeZManjVajamiOdZManjOcenOd(int minStVaj, int minStOcen);

    //SQL stavel: SELECT vad.id FROM vadba vad LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING vad.id IN( SELECT vad.id FROM vadba vad LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>=1 ) AND vad.id IN( SELECT vad.id FROM vadba vad LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING AVG(o.ocena)>=6 );
    @Query(value="SELECT vad.id FROM vadba vad LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING vad.id IN( SELECT vad.id FROM vadba vad LEFT JOIN vadba_vaje vv ON vv.vadba_id = vad.id LEFT JOIN vaja vaj ON vv.vaje_id = vaj.id GROUP BY vad.id HAVING COUNT(vaj.id)>= ?1 ) AND vad.id IN( SELECT vad.id FROM vadba vad LEFT JOIN vadba_ocene vo ON vo.vadba_id = vad.id LEFT JOIN ocena o ON vo.ocene_id = o.id GROUP BY vad.id HAVING AVG(o.ocena)>= ?2 );", nativeQuery=true)
    List<Long> vrniVadbeZVecVajamiOdInPovprecjeOcenOd(int minStVaj, int minPovprecjeOcen);

}
