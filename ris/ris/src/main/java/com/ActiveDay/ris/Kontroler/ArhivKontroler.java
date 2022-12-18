package com.ActiveDay.ris.Kontroler;

import com.ActiveDay.ris.Model.*;
import com.ActiveDay.ris.Repozitorij.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/arhiv")
@CrossOrigin
public class ArhivKontroler {
    @Autowired
    private ArhivRepozitorij arhivDao;

    //vrne vse arhive
    @GetMapping("")
    public Iterable<Arhiv> vrniVseArhive() {
        return arhivDao.findAll();
    }

    //vrne arhiv z dolocenim arhivom
    @GetMapping("{id}")
    public Optional<Arhiv> vrniArhiv(@PathVariable(name="id") Long id) {
        return arhivDao.findById(id);
    }

    //doda nov arhiv
    @PostMapping("")
    public Arhiv dodajArhiv(@RequestBody Arhiv arhiv){
        return arhivDao.save(arhiv);
    }

    //spremeni arhiv glede na id
    @PutMapping("{id}")
    public Arhiv spremeniArhiv(@PathVariable(name="id") Long id, @RequestBody Arhiv arhiv) {

        if(!arhivDao.existsById(id))
            return null;

            arhiv.setId(id);
        return arhivDao.save(arhiv);
    }

    //izbrise arhiv glede na id - vrne true ali false, glede na to a je uspelo ali ne
    @DeleteMapping("{id}")
    public Boolean izbrisiArhiv(@PathVariable(name="id") Long id) {

        if(!arhivDao.existsById(id))
            return false;
            arhivDao.deleteById(id);
        return true;
    }

    //vrne arhive ki majo vadbe ki majo v nazivu "kondicijsko"
    @GetMapping("kondicijskeVadbe/{naziv}")
    public Iterable<Arhiv> vrniArhivZKondicijskimiVadbami(@PathVariable(name="naziv") String naziv) {
        return arhivDao.vrniArhivZKondicijskimiVadbami(naziv);
    }

    //vrne arhive ki majo vadbe ki majo vec st intervalov kot 1
    @GetMapping("vadbe/vecIntervalov")
    public Iterable<Arhiv> vrniArhivGledeNaIntervaleVadb(@PathVariable(name="stIntervalov") int stIntervalov) {
        return arhivDao.vrniArhivGledeNaIntervaleVadb(stIntervalov);
    }
}
