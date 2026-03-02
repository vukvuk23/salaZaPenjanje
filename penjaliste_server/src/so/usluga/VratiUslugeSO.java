/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.usluga;

import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Usluga;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class VratiUslugeSO extends ApstraktnaSO {
    private List<Usluga> usluge;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Usluga)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Usluga!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Usluga u = (Usluga) odo;
        usluge = (List<Usluga>) repository.getAll(u, null); 
        
        if(usluge == null){
            System.out.println("Usluge nisu vracene!");
        }
    }

    public List<Usluga> getUsluge() {
        return usluge;
    }
}
