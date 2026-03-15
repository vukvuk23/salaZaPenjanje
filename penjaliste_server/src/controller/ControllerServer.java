/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.Kategorija;
import model.Penjac;
import model.Racun;
import model.Smena;
import model.Usluga;
import model.Zaposleni;
import so.kategorija.VratiKategorijeSO;
import so.login.LoginSO;
import so.penjac.UbacijPenjacSO;
import so.penjac.ObrisiPenjacSO;
import so.penjac.PretraziPenjacSO;
import so.penjac.PromeniPenjacSO;
import so.penjac.VratiPenjacSO;
import so.penjac.VratiPenjaceSO;
import so.racun.UbaciRacunSO;
import so.racun.PretraziRacunSO;
import so.racun.PromeniRacunSO;
import so.racun.VratiRacunSO;
import so.racun.VratiRacuneSO;
import so.smena.UbaciSmenaSo;
import so.usluga.VratiUslugeSO;
import so.zaposleni.VratiZaposleneSO;

/**
 *
 * @author Administrator
 */
public class ControllerServer {
    private static ControllerServer instance;
    
    private ControllerServer(){
        
    }
    
    public static ControllerServer getInstance() {
        if (instance == null) instance = new ControllerServer();
        return instance;
    }

    public Zaposleni login(Zaposleni zaposleni) throws Exception {
        LoginSO so = new LoginSO();
        so.izvrsi(zaposleni);
        return so.getUlogovani();
    }

    public List<Penjac> vratiPenjace() throws Exception {
        VratiPenjaceSO so = new VratiPenjaceSO();
        Penjac p = new Penjac();
        so.izvrsi(p);
        return so.getPenjaci();
    }

    public List<Kategorija> vratiKategorije() throws Exception {
        VratiKategorijeSO so = new VratiKategorijeSO();
        Kategorija k = new Kategorija();
        so.izvrsi(k);
        return so.getKategorije();
    }

    public void ubaciPenjaca(Penjac p) throws Exception {
        UbacijPenjacSO so = new UbacijPenjacSO();
        so.izvrsi(p);
    }

    public void promeniPenjaca(Penjac p) throws Exception {
        PromeniPenjacSO so = new PromeniPenjacSO();
        so.izvrsi(p);
    }

    public void obrisiPenjaca(Penjac p) throws Exception {
        ObrisiPenjacSO so = new ObrisiPenjacSO();
        so.izvrsi(p);
    }

    public List<Penjac> pretraziPenjace(Penjac p) throws Exception {
        PretraziPenjacSO so = new PretraziPenjacSO();
        so.izvrsi(p);
        return so.getPenjaci();
    }

    public List<Racun> vratiRacune() throws Exception {
        VratiRacuneSO so = new VratiRacuneSO();
        Racun r = new Racun();
        so.izvrsi(r);
        return so.getRacuni();
    }

    public List<Zaposleni> vratiZaposlene() throws Exception {
        VratiZaposleneSO so = new VratiZaposleneSO();
        Zaposleni z = new Zaposleni();
        so.izvrsi(z);
        return so.getZaposleni();
    }

    public List<Usluga> vratiUsluge() throws Exception {
        VratiUslugeSO so = new VratiUslugeSO();
        Usluga u = new Usluga();
        so.izvrsi(u);
        return so.getUsluge();
    }

    public void ubaciRacun(Racun r) throws Exception {
        UbaciRacunSO so = new UbaciRacunSO();
        so.izvrsi(r);
    }

    public void promeniRacun(Racun r) throws Exception {
        PromeniRacunSO so = new PromeniRacunSO();
        so.izvrsi(r);
    }

    public List<Racun> pretraziRacune(Racun r) throws Exception {
        PretraziRacunSO so = new PretraziRacunSO();
        so.izvrsi(r);
        return so.getRacuni();
    }
    
    public void ubaciSmenu(Smena smena) throws Exception {
        UbaciSmenaSo so = new UbaciSmenaSo();
        so.izvrsi(smena);
    }

    public Racun vratiRacun(Racun r) throws Exception {
        VratiRacunSO so = new VratiRacunSO();
        so.izvrsi(r);
        return so.getRacun();
    }

    public Penjac vratiPenjaca(Penjac p) throws Exception {
        VratiPenjacSO so = new VratiPenjacSO();
        so.izvrsi(p);
        return so.getPenjac();
    }
}
