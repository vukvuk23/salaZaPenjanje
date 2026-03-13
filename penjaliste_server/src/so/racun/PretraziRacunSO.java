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
public class PretraziRacunSO extends ApstraktnaSO {
    private List<Racun> racuni;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Racun)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Racun!");
        }

        Racun racun = (Racun) odo;

        if (racun.getZaposleni() == null && racun.getPenjac() == null) {
            throw new Exception("Morate uneti bar jedan kriterijum pretrage!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Racun racun = (Racun) odo;
        racuni = repository.getAll(racun);
        
        for (Racun r : racuni) {
            StavkaRacuna sr = new StavkaRacuna();
            sr.setRacun(r);
            List<StavkaRacuna> stavke = repository.getAll(sr);
            r.setStavkeRacuna(stavke);
        }
        
        if (racuni.isEmpty()) {
            throw new Exception("Sistem ne moze da nadje racune po zadatim kriterijumima!");
        }
    }

    public List<Racun> getRacuni() {
        return racuni;
    }
}
