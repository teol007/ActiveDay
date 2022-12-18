package com.ActiveDay.ris.Kontroler;

import com.ActiveDay.ris.Model.*;
import com.ActiveDay.ris.Repozitorij.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("/vadba")
@CrossOrigin
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

    @PostMapping("{id}/vaja")
    public Vadba dodajVadbo(@PathVariable(name="id") Long id, @RequestBody Vaja vaja) {
        Vaja shranjenaVaja = vajaDao.save(vaja);
        vadbaDao.findById(id).get().dodajVajo(shranjenaVaja);
        return vadbaDao.save(vadbaDao.findById(id).get());
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

    @GetMapping("vajVsaj/{minStVaj}/ocenVsaj/{minStOcen}")
    public Iterable<Vadba> vrniVadbeZVecVajamiOdZVecOcenOd(@PathVariable(name="minStVaj") int minStVaj, @PathVariable(name="minStOcen") int minStOcen) {
        return vadbaDao.findAllById(vadbaDao.vrniVadbeZVecVajamiOdZVecOcenOd(minStVaj, minStOcen));
    }

    @GetMapping("vajNajvec/{maxStVaj}/ocenNajvec/{maxStOcen}")
    public Iterable<Vadba> vrniVadbeZManjVajamiOdZManjOcenOd(@PathVariable(name="maxStVaj") int maxStVaj, @PathVariable(name="maxStOcen") int maxStOcen) {
        return vadbaDao.findAllById(vadbaDao.vrniVadbeZManjVajamiOdZManjOcenOd(maxStVaj, maxStOcen));
    }

    @GetMapping("vajVsaj/{minStVaj}/povprecjeOcenVsaj/{minPovpOcen}")
    public Iterable<Vadba> vrniVadbeZVecVajamiOdInPovprecjeOcenOd(@PathVariable(name="minStVaj") int minStVaj, @PathVariable(name="minPovpOcen") int minPovpOcen) {
        return vadbaDao.findAllById(vadbaDao.vrniVadbeZVecVajamiOdInPovprecjeOcenOd(minStVaj, minPovpOcen));
    }

}
