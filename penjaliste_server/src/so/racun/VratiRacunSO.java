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
public class VratiRacunSO extends ApstraktnaSO{
    private Racun racun;

    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Racun)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Racun!");
        }
        
        Racun r = (Racun) odo;
        
        if (r.getIdRacun() == null) {
            throw new Exception("Racun mora imati ID!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Racun r = (Racun) odo;
        racun = (Racun) repository.get(r);
        if (racun == null) {
            throw new Exception("Sistem ne moze da nadje racun!");
        }
        StavkaRacuna sr = new StavkaRacuna();
        sr.setRacun(racun);
        List<StavkaRacuna> stavke = repository.getAll(sr);
        racun.setStavkeRacuna(stavke);
    }

    public Racun getRacun() {
        return racun;
    }
}
