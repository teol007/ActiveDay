package com.ActiveDay.ris.Kontroler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ActiveDay.ris.Model.EmailService;

@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmailServiceKontroler
{
    @Autowired
    private EmailService emailDao;

    @PostMapping("poslji")
    public boolean dodajVadbo(@RequestBody Map<String, Object> podatki)
    {
        return emailDao.sendSimpleMail(podatki.get("prejemnik").toString(), podatki.get("naslov").toString(), podatki.get("vsebina").toString());
    }
    
}
