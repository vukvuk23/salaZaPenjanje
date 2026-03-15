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
public class VratiPenjacSO extends ApstraktnaSO{
    private Penjac penjac;

    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Penjac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Penjac!");
        }
        
        Penjac p = (Penjac) odo;
        
        if (p.getIdPenjac() == null) {
            throw new Exception("Penjac mora imati ID!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Penjac p = (Penjac) odo;
        penjac = (Penjac) repository.get(p);
        
        if (penjac == null) {
            throw new Exception("Sistem ne moze da nadje penjaca!");
        }
    }

    public Penjac getPenjac() {
        return penjac;
    }
}
