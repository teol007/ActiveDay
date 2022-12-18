package com.ActiveDay.ris.Kontroler;

import com.ActiveDay.ris.Model.*;
import com.ActiveDay.ris.Repozitorij.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/uporabnik")
@CrossOrigin
public class UporabnikKontroler {
    @Autowired
    private UporabnikRepozitorij uporabnikDao;

    @GetMapping("")
    public Iterable<Uporabnik> vrniVseUporabnike() {
        return uporabnikDao.findAll();
    }

    @GetMapping("{id}")
    public Optional<Uporabnik> vrniUporabnika(@PathVariable(name="id") Long id) {
        return uporabnikDao.findById(id);
    }

    @PostMapping("")
    public Uporabnik dodajUporabnika(@RequestBody Uporabnik uporabnik)
    {return uporabnikDao.save(uporabnik);}

    @PutMapping("{id}")
    public Uporabnik spremeniUporabnika(@PathVariable(name="id") Long id, @RequestBody Uporabnik uporabnik) {

        if(!uporabnikDao.existsById(id))
            return null;

        uporabnik.setId(id);
        return uporabnikDao.save(uporabnik);
    }

    @DeleteMapping("{id}")
    public Boolean izbrisiUporabnika(@PathVariable(name="id") Long id) {

        if(!uporabnikDao.existsById(id))
            return false;
        uporabnikDao.deleteById(id);
        return true;
    }

    @GetMapping("/ime/{ime}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniDolocenegaUporabnika(@PathVariable(name = "ime") String ime, @PathVariable(name = "priimek") String priimek) {
        return uporabnikDao.vrniDolocenegaUporabnika(ime, priimek);
    }

    @GetMapping("/ime/{ime}/uporabniskoIme/{uporabniskoIme}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniUporabniskiNiz(@PathVariable(name = "ime") String ime, @PathVariable(name = "uporabniskoIme") String uporabniskoIme, @PathVariable(name = "priimek") String priimek) {
        return uporabnikDao.vrniUporabniskiNiz(ime, uporabniskoIme, priimek);
    }

    @GetMapping("/geslo/{geslo}/uporabniskoIme/{uporabniskoIme}/priimek/{priimek}")
    public Iterable<Uporabnik> vrniUporabnikeNovake(@PathVariable(name="geslo") String geslo, @PathVariable(name="uporabniskoIme") String uporabniskoIme, @PathVariable(name = "priimek") String priimek) {
        return uporabnikDao.vrniUporabnikeNovake(geslo, uporabniskoIme, priimek);
    }

    //------------REGISTRACIJA--------------------

    @PostMapping("/registracija")
    public boolean registracijaUporabnika(@RequestBody Uporabnik uporabnik){
        List<Uporabnik> tempUporabnik = uporabnikDao.preveriCeEmailObstaja(uporabnik.getEmail());
        if(tempUporabnik.size() > 0){
            return false;
        }
        uporabnikDao.save(uporabnik);
        System.out.println("Registracija je bila uspesna!");
        return true;
    }

    //----------------PRIJAVA-------------
     @PostMapping("/prijava/{email}/{geslo}")
    public boolean vrniUporabnikaLogin(@PathVariable(name="geslo") String email, @PathVariable(name="geslo") String geslo) {
        //more vrnit uporabnika al true/false?        
        List<Uporabnik> tempUporabnik = uporabnikDao.vrniUporabnikaLogin(email, geslo);
        if(tempUporabnik.size() > 0){
            System.out.println("Prijava je bila uspesna!");
            return true;
        }
        return false;
    }
    
}
