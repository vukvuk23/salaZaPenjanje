/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.racun;

import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Racun;
import model.StavkaRacuna;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class PromeniRacunSO extends ApstraktnaSO{
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Racun)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Racun!");
        }

        Racun r = (Racun) odo;

        if (r.getZaposleni() == null) {
            throw new Exception("Zaposleni mora biti izabran!");
        }
        if (r.getPenjac() == null) {
            throw new Exception("Penjac mora biti izabran!");
        }
        if (r.getStavkeRacuna() == null || r.getStavkeRacuna().isEmpty()) {
            throw new Exception("Racun mora imati bar jednu stavku!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Racun r = (Racun) odo;

        r.izracunajUkupanIznos();

        repository.edit(r);

        StavkaRacuna sr = new StavkaRacuna();
        sr.setRacun(r);
        List<StavkaRacuna> stavke = repository.getAll(sr);
        for (StavkaRacuna s : stavke) {
            repository.delete(s);
        }

        for (StavkaRacuna s : r.getStavkeRacuna()) {
            s.setRacun(r);
            repository.add(s);
        }
    }
}
