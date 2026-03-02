/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.racun;

import model.OpstiDomenskiObjekat;
import model.Racun;
import model.StavkaRacuna;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class KreirajRacunSO extends ApstraktnaSO {

     @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Racun)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Racun!");
        }

        Racun racun = (Racun) odo;

        if (racun.getZaposleni() == null) {
            throw new Exception("Zaposleni nije izabran!");
        }

        if (racun.getPenjac() == null) {
            throw new Exception("Penjac nije izabran!");
        }

        if (racun.getStavkeRacuna() == null || racun.getStavkeRacuna().isEmpty()) {
            throw new Exception("Racun mora imati bar jednu stavku!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Racun racun = (Racun) odo;

        repository.add(racun);

        for (StavkaRacuna s : racun.getStavkeRacuna()) {
            s.setRacun(racun);
            repository.add(s);
        }
    }
    
}
