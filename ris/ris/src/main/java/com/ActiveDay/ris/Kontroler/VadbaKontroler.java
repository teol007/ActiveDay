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

    @GetMapping("vajVsaj/{stVaj}")
    public Iterable<Vadba> vrniVadbeZVecVajamiOd(@PathVariable(name="stVaj") int stVaj) {
        return vadbaDao.findAllById(vadbaDao.vrniVadbeZVecVajamiOd(stVaj));
    }

    @GetMapping("vajNajvec/{stVaj}")
    public Iterable<Vadba> vrniVadbeZManjVajamiOd(@PathVariable(name="stVaj") int stVaj) {
        return vadbaDao.findAllById(vadbaDao.vrniVadbeZManjVajamiOd(stVaj));
    }

    /* @PostMapping("/{id}/dodajVajo")
    public Vadba dodajVajoVadbi(@PathVariable(name="id") Long id, @RequestBody Vaja vaja) {
        vadbaDao.findById(id).get().dodajVajo(vaja);
        return vadbaDao.findById(id).get();
        //return vadbaDao.save(vadba);
    } */

}
