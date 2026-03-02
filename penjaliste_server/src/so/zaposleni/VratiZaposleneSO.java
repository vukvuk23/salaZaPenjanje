/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.zaposleni;

import java.util.List;
import model.OpstiDomenskiObjekat;
import model.Zaposleni;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class VratiZaposleneSO extends ApstraktnaSO {
    private List<Zaposleni> zaposleni;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Zaposleni z = (Zaposleni) odo;
        zaposleni = (List<Zaposleni>) repository.getAll(z, null); 
        
        if(zaposleni == null){
            System.out.println("Zaposleni nisu vraceni!");
        }
    }

    public List<Zaposleni> getZaposleni() {
        return zaposleni;
    }
}
