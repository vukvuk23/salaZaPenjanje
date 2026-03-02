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
public class VratiPenjaceSO extends ApstraktnaSO {
    List<Penjac> penjaci;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Penjac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Penjac!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Penjac p = (Penjac) odo;;
        penjaci = (List<Penjac>) repository.getAll(p, null); 
        
        if(penjaci == null){
            System.out.println("Penjaci nisu vraceni!");
        }
    }

    public List<Penjac> getPenjaci() {
        return penjaci;
    }
}
