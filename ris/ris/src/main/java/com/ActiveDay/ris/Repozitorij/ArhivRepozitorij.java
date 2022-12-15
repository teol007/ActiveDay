package com.ActiveDay.ris.Repozitorij;

import com.ActiveDay.ris.Model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArhivRepozitorij extends CrudRepository<Arhiv, Long> {

    //query kjer vrne arhiv, ki ima vadbe, ki imajo nekje v imenu kondicijsko
    @Query(value="SELECT a.id FROM arhiv a INNER JOIN arhiv_vadba arhVad ON arhVad.arhiv_id = a.id INNER JOIN vadba v ON arhVad.vadba_id = v.id WHRERE v.ime LIKE %kondicijo& GROUP BY a.id;", nativeQuery=true)
    List<Arhiv> vrniArhivZKondicijskimiVadbami(String naziv);

    //query kjer vrne arhiv ki ima vadbe z stevilom intervalov vec kot 1
    @Query(value="SELECT a.id FROM arhiv a INNER JOIN arhiv_vadba arhVad ON arhVad.arhiv_id = a.id INNER JOIN vadba v ON arhVad.vadba_id = v.id GROUP BY a.id HAVING COUNT (v.id) >=? 1 ;", nativeQuery=true)
    List<Arhiv> vrniArhivGledeNaIntervaleVadb(int stIntervalov);
    
}
