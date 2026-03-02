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
public class VratiRacuneSO extends ApstraktnaSO {
    List<Racun> racuni;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Racun)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Racun!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Racun r = (Racun) odo;
        racuni = (List<Racun>) (List<?>) repository.getAll(r, "");

        for (Racun racun : racuni) {
            StavkaRacuna sr = new StavkaRacuna();
            sr.setRacun(racun);
            List<StavkaRacuna> stavke = (List<StavkaRacuna>) (List<?>) repository.getAll(new StavkaRacuna(), sr.uslovZaSelect());
            racun.setStavkeRacuna(stavke);
        }
    }

    public List<Racun> getRacuni() {
        return racuni;
    }
}
