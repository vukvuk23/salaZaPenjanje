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
public class PromeniPenjacSO extends ApstraktnaSO{

    @Override
    protected void preduslov(OpstiDomenskiObjekat odo) throws Exception {
        if (!(odo instanceof Penjac)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Penjac!");
        }
        
        Penjac p = (Penjac) odo;
        
        if (p.getIme() == null || p.getIme().isBlank()) {
            throw new Exception("Ime penjaca ne sme biti prazno!");
        }
        if (p.getPrezime() == null || p.getPrezime().isBlank()) {
            throw new Exception("Prezime penjaca ne sme biti prazno!");
        }
        if (p.getGodine() <= 5) {
            throw new Exception("Broj godina penjaca mora biti veci od 5");
        }
        if (p.getEmail() == null || !p.getEmail().contains("@")) {
            throw new Exception("Email penjaca nije u ispravnom formatu!");
        }
        if (p.getKategorija() == null) {
            throw new Exception("Kategorija penjaca mora biti izabrana!");
        }
        
        String uslov = " WHERE p.ime = '" + p.getIme() + "' AND p.prezime = '" + p.getPrezime() + "' AND p.email = '" + p.getEmail() + "' AND p.idPenjac != " + p.getIdPenjac();
        // mozda getAll()
        Penjac vecPostojeci = (Penjac) repository.get(p, uslov);
        if (vecPostojeci != null) {
            throw new Exception("Sistem ne moze da izmeni penjaca. Penjac vec postoji!");
        }
    }

    @Override
    protected void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception {
        Penjac p = (Penjac) odo;
        repository.edit(p);
    }
}
