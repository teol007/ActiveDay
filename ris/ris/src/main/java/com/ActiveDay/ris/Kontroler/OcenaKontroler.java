package com.ActiveDay.ris.Kontroler;

import com.ActiveDay.ris.Model.*;
import com.ActiveDay.ris.Repozitorij.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/ocena")
@CrossOrigin
public class OcenaKontroler {
    @Autowired
    private OcenaRepozitorij ocenaDao;

    @GetMapping("")
    public Iterable<Ocena> vrniVseVaje() {
        return ocenaDao.findAll();
    }

    @GetMapping("{id}")
    public Optional<Ocena> vrniVajo(@PathVariable(name="id") Long id) {
        return ocenaDao.findById(id);
    }

    @PostMapping("")
    public Ocena dodajVajo(@RequestBody Ocena ocena)
    {return ocenaDao.save(ocena);}

    @PutMapping("{id}")
    public Ocena spremeniVajo(@PathVariable(name="id") Long id, @RequestBody Ocena ocena) {
        //Kaj naret, da bi vrnilo izpis neke napake?
        if(!ocenaDao.existsById(id))
            return null;

        ocena.setId(id);
        return ocenaDao.save(ocena);
    }

    @DeleteMapping("{id}")
    public Boolean izbrisiVajo(@PathVariable(name="id") Long id) {
        //Kaj naret, da bi vrnilo izpis neke napake?
        if(!ocenaDao.existsById(id))
            return false;
        ocenaDao.deleteById(id);
        return true;
    }
    
}
