/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.util.List;
import komunikacija.Komunikacija;
import komunikacija.Odgovor;
import komunikacija.Operacije;
import komunikacija.Zahtev;
import model.Kategorija;
import model.Penjac;
import model.Racun;
import model.Smena;
import model.Usluga;
import model.Zaposleni;

/**
 *
 * @author Administrator
 */
public class ControllerClient {
    private static ControllerClient instance;
    private Zaposleni ulogovani;
    
    private ControllerClient(){
        
    }
    
    public static ControllerClient getInstance(){
        if(instance==null) instance=new ControllerClient();
        return instance;
    }

    public Zaposleni login(String email, String lozinka) throws Exception {
        Zaposleni z = new Zaposleni();
        z.setEmail(email);
        z.setLozinka(lozinka);
        
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, z);
        Odgovor odgovor = Komunikacija.getInstance().login(zahtev);
        
        if(odgovor.getEx() == null){
            return (Zaposleni) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public List<Penjac> vratiPenjace() throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.VRATI_PENJACE, null);
        Odgovor odgovor = Komunikacija.getInstance().vratiPenjace(zahtev);
        
        if(odgovor.getEx() == null){
            return (List<Penjac>) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public List<Kategorija> vratiKategorije() throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.VRATI_KATEGORIJE, null);
        Odgovor odgovor = Komunikacija.getInstance().vratiKategorije(zahtev);
        
        if(odgovor.getEx() == null){
            return (List<Kategorija>) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public void kreirajPenjaca(Penjac p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_PENJAC, p);
        Odgovor odgovor = Komunikacija.getInstance().kreirajPenjaca(zahtev);
        
        if(odgovor.getEx() == null){
            
        } else {
            throw odgovor.getEx();
        }
    }

    public void promeniPenjaca(Penjac p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.PROMENI_PENJAC, p);
        Odgovor odgovor = Komunikacija.getInstance().promeniPenjaca(zahtev);
        
        if(odgovor.getEx() == null){
            
        } else {
            throw odgovor.getEx();
        }
    }

    public void obrisiPenjaca(Penjac p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.OBRISI_PENJAC, p);
        Odgovor odgovor = Komunikacija.getInstance().obrisiPenjaca(zahtev);
        
        if(odgovor.getEx() == null){
            
        } else {
            throw odgovor.getEx();
        }
    }

    public List<Penjac> pretraziPenjace(Penjac p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.PRETRAZI_PENJAC, p);
        Odgovor odgovor = Komunikacija.getInstance().pretraziPenjace(zahtev);
        
        if(odgovor.getEx() == null){
            return (List<Penjac>) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public List<Racun> vratiRacune() throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.VRATI_RACUNE, null);
        Odgovor odgovor = Komunikacija.getInstance().vratiRacune(zahtev);
        
        if(odgovor.getEx() == null){
            return (List<Racun>) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public List<Zaposleni> vratiZaposlene() throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.VRATI_ZAPOSLENE, null);
        Odgovor odgovor = Komunikacija.getInstance().vratiZaposlene(zahtev);
        
        if(odgovor.getEx() == null){
            return (List<Zaposleni>) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public List<Usluga> vratiUsluge() throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.VRATI_USLUGE, null);
        Odgovor odgovor = Komunikacija.getInstance().vratiUsluge(zahtev);
        
        if(odgovor.getEx() == null){
            return (List<Usluga>) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public void kreirajRacun(Racun r) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.KREIRAJ_RACUN, r);
        Odgovor odgovor = Komunikacija.getInstance().kreirajRacun(zahtev);
        
        if(odgovor.getEx() == null){
            
        } else {
            throw odgovor.getEx();
        }
    }

    public void izmeniRacun(Racun r) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.PROMENI_RACUN, r);
        Odgovor odgovor = Komunikacija.getInstance().izmeniRacun(zahtev);
        
        if(odgovor.getEx() == null){
            
        } else {
            throw odgovor.getEx();
        }
    }

    public List<Racun> pretraziRacune(Racun r) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.PRETRAZI_RACUN, r);
        Odgovor odgovor = Komunikacija.getInstance().pretraziRacune(zahtev);
        
        if(odgovor.getEx() == null){
            return (List<Racun>) odgovor.getOdgovor();
        } else {
            throw odgovor.getEx();
        }
    }

    public void ubaciSmenu(Smena smena) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.UBACI_SMENA, smena);
        Odgovor odgovor = Komunikacija.getInstance().ubaciSmenu(zahtev);
        
        if(odgovor.getEx() == null){
            
        } else {
            throw odgovor.getEx();
        }
    }
}
