/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.smena;

import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Smena;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class UbaciSmenaSo extends ApstraktnaSO {
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Smena)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Smena!");
        }

        Smena smena = (Smena) odo;

        if (smena.getNaziv() == null || smena.getNaziv().isBlank()) {
            throw new Exception("Naziv smene ne moze biti prazan!");
        }
        if (smena.getVremeOd() == null) {
            throw new Exception("Vreme pocetka smene nije uneto!");
        }
        if (smena.getVremeDo() == null) {
            throw new Exception("Vreme kraja smene nije uneto!");
        }
        if (!smena.getVremeOd().isBefore(smena.getVremeDo())) {
            throw new Exception("Vreme pocetka mora biti prije vremena kraja!");
        }

        List<Smena> smene = repository.getAll(smena, null);
        for (Smena s : smene) {
            if (s.getNaziv().equalsIgnoreCase(smena.getNaziv())) {
                throw new Exception("Smena sa tim nazivom vec postoji!");
            }
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        repository.add(odo);
    }
}
