package com.ActiveDay.ris.Repozitorij;

import com.ActiveDay.ris.Model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UporabnikRepozitorij extends CrudRepository<Uporabnik, Long>{

    //preveri pogoje!!
    @Query(value="SELECT * FROM uporabnik u WHERE u.ime='uros' AND u.priimek='novak' ", nativeQuery=true)
    List<Uporabnik> vrniDolocenegaUporabnika(String ime, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.ime='uros' AND u.uporabniskoIme LIKE %urosnovak% AND u.priimek='novak' ", nativeQuery=true)
    List<Uporabnik> vrniUporabniskiNiz(String ime, String uporabniskoIme, String priimek);

    @Query(value="SELECT * FROM uporabnik u WHERE u.geslo LIKE %novak% OR u.uporabniskoIme LIKE %novak% OR u.priimek = %novak%", nativeQuery=true)
    List<Uporabnik> vrniUporabnikeNovake(String geslo, String uporabniskoIme, String priimek);

    //za prijavo
    @Query(value="SELECT * FROM uporabnik u WHERE u.geslo = ? AND u.email = ? LIMIT 1 ", nativeQuery=true)
    List<Uporabnik> vrniUporabnikaLogin(String geslo, String email);

    //za registracijo
    @Query(value="SELECT * FROM uporabnik u WHERE u.email = ? ", nativeQuery=true)
    List<Uporabnik> preveriCeEmailObstaja( String email);
    
}
