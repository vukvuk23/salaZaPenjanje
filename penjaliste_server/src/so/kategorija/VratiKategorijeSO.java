/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.kategorija;

import java.util.List;
import model.Kategorija;
import model.OpstiDomenskiObjekat;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class VratiKategorijeSO extends ApstraktnaSO {
    List<Kategorija> kategorije;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Kategorija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kategorija!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Kategorija k = (Kategorija) odo;
        kategorije = repository.getAll(k); 
        
        if(kategorije.isEmpty()){
            throw new Exception("Kategorije nisu vracene!");
        }
    }

    public List<Kategorija> getKategorije() {
        return kategorije;
    }
}
