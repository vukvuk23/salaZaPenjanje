/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.penjac;

import model.OpstiDomenskiObjekat;
import model.Penjac;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class ObrisiPenjacSO extends ApstraktnaSO{

    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Penjac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Penjac!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Penjac p = (Penjac) odo;
        repository.delete(p);
    }
}
