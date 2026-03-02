/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so.login;

import model.OpstiDomenskiObjekat;
import model.Zaposleni;
import so.ApstraktnaSO;

/**
 *
 * @author Administrator
 */
public class LoginSO extends ApstraktnaSO{
    private Zaposleni ulogovani;
    
    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (odo == null || !(odo instanceof Zaposleni)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Zaposleni!");
        }
        
        Zaposleni z = (Zaposleni) odo;
        if (z.getEmail() == null || z.getEmail().isEmpty()) {
            throw new Exception("Email ne moze biti prazan!");
        }
        if (z.getLozinka() == null || z.getLozinka().isEmpty()) {
            throw new Exception("Lozinka ne moze biti prazna!");
        } // da li je vec ulogovan?
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Zaposleni z = (Zaposleni) odo;
        String uslov = " WHERE email = '" + z.getEmail() + "' AND lozinka = '" + z.getLozinka() + "'";
        ulogovani = (Zaposleni) repository.get(z, uslov);
        if(ulogovani == null){
            throw new Exception("Email i sifra nisu ispravni!");
        }
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }
    
}
