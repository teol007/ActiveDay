package com.ActiveDay.ris.Kontroler;

import com.ActiveDay.ris.Model.Vaja;
import com.ActiveDay.ris.Repozitorij.VajaRepozitorij;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.InvalidKeyException;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_MODIFIED;

@RestController
@RequestMapping("/vaja")
public class VajaKontroler {
    @Autowired
    private VajaRepozitorij vajaDao;

    @GetMapping("")
    public Iterable<Vaja> vrniVseVaje() {
        return vajaDao.findAll();
    }

    @GetMapping("{id}")
    public Optional<Vaja> vrniVajo(@PathVariable(name="id") Long id) {
        return vajaDao.findById(id);
    }

    @PostMapping("")
    public Vaja dodajVajo(@RequestBody Vaja vaja)
    {return vajaDao.save(vaja);}

    @PutMapping("{id}")
    public Vaja spremeniVajo(@PathVariable(name="id") Long id, @RequestBody Vaja vaja) {
        //Kaj naret, da bi vrnilo izpis neke napake?
        if(!vajaDao.existsById(id))
            return null;

        vaja.setId(id);
        return vajaDao.save(vaja);
    }

    @DeleteMapping("{id}")
    public Boolean izbrisiVajo(@PathVariable(name="id") Long id) {
        //Kaj naret, da bi vrnilo izpis neke napake?
        if(!vajaDao.existsById(id))
            return false;
        vajaDao.deleteById(id);
        return true;
    }

    @GetMapping("/ponovitve/{stPonovitev}/velikost/{maxTrajanje}")
    public Iterable<Vaja> vrniVajeTezavnosti(@PathVariable(name = "stPonovitev") int stPonovitev, @PathVariable(name = "maxTrajanje") long maxTrajanje) {
        return vajaDao.vrniVajeTezavnosti(stPonovitev, maxTrajanje);
    }

    @GetMapping("/naziv/{naziv}/ponovitve/{stPonovitev}/velikost/{maxTrajanje}")
    public Iterable<Vaja> vrniVajeTezavnosti(@PathVariable(name = "naziv") String naziv, @PathVariable(name = "stPonovitev") int stPonovitev, @PathVariable(name = "maxTrajanje") long maxTrajanje) {
        return vajaDao.vrniDoloceneVajeTezavnosti(naziv, stPonovitev, maxTrajanje);
    }


}
