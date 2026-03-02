/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.penjac;

import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Penjac;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class PretraziPenjacSO extends ApstraktnaSO{
    private List<Penjac> penjaci;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Penjac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Penjac!");
        }
        
        Penjac p = (Penjac) odo;
        
        if (p.getIme().isEmpty() && p.getPrezime().isEmpty() && p.getKategorija() == null) {
            throw new Exception("Barem jedan kriterijum za pretragu mora biti popunjen!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Penjac p = (Penjac) odo;
        penjaci = repository.getAll(p, p.uslovZaSelect());
        
        if (penjaci.isEmpty()) {
            throw new Exception("Ne postoje penjaci po zadatim kriterijumima");
        }
    }

    public List<Penjac> getPenjaci() {
        return penjaci;
    }
}
