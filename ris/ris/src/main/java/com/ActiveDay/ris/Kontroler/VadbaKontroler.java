package com.ActiveDay.ris.Kontroler;

import com.ActiveDay.ris.Model.*;
import com.ActiveDay.ris.Repozitorij.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/vadba")
public class VadbaKontroler {
    @Autowired
    private VadbaRepozitorij vadbaDao;
    @Autowired
    private VajaRepozitorij vajaDao;

    @GetMapping("")
    public Iterable<Vadba> vrniVseVadbe() {
        return vadbaDao.findAll();
    }

    @GetMapping("{id}")
    public Optional<Vadba> vrniVadbo(@PathVariable(name="id") Long id) {
        return vadbaDao.findById(id);
    }

    @PostMapping("")
    public Vadba dodajVadbo(@RequestBody Vadba vadba) {
        //! System.out.println("abc\n");
        //! System.out.println(vadba);
        //vajaDao.saveAll(vadba.getVaje());
        return vadbaDao.save(vadba);
    }

    @PutMapping("{id}")
    public Vadba spremeniVadbo(@PathVariable(name="id") Long id, @RequestBody Vadba vadba) {
        //Kaj naret, da bi vrnilo izpis neke napake?
        if(!vadbaDao.existsById(id))
            return null;

        vadba.setId(id);
        return vadbaDao.save(vadba);
    }

    @DeleteMapping("{id}")
    public Boolean izbrisiVadbo(@PathVariable(name="id") Long id) {
        //Kaj naret, da bi vrnilo izpis neke napake?
        if(!vadbaDao.existsById(id))
            return false;
        vadbaDao.deleteById(id);
        return true;
    }
/* 
    @GetMapping("/ponovitve/{stPonovitev}/velikost/{maxTrajanje}")
    public Iterable<Vadba> vrniVadbeTezavnosti(@PathVariable(name = "stPonovitev") int stPonovitev, @PathVariable(name = "maxTrajanje") long maxTrajanje) {
        return vadbaDao.vrniVadbeTezavnosti(stPonovitev, maxTrajanje);
    }

    @GetMapping("/naziv/{naziv}/ponovitve/{stPonovitev}/velikost/{maxTrajanje}")
    public Iterable<Vadba> vrniDoloceneVadbeTezavnosti(@PathVariable(name = "naziv") String naziv, @PathVariable(name = "stPonovitev") int stPonovitev, @PathVariable(name = "maxTrajanje") long maxTrajanje) {
        return vadbaDao.vrniDoloceneVadbeTezavnosti(naziv, stPonovitev, maxTrajanje);
    }

    @GetMapping("/naziv/{naziv}/opisbrez/{niz}/ponovitve/{stPonovitev}/velikost/{maxTrajanje}")
    public Iterable<Vadba> vrniDoloceneVadbeTezavnostiBrez(@PathVariable(name="naziv") String naziv, @PathVariable(name="niz") String nizBrez, @PathVariable(name = "stPonovitev") int stPonovitev, @PathVariable(name = "maxTrajanje") long maxTrajanje) {
        return vadbaDao.vrniDoloceneVadbeTezavnostiBrez(naziv, nizBrez, stPonovitev, maxTrajanje);
    }
 */

}
