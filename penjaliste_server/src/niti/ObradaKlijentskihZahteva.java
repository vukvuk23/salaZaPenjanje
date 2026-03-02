/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.ControllerServer;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Reciever;
import komunikacija.Sender;
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
public class ObradaKlijentskihZahteva extends Thread{
    private Socket s;
    private Sender sender;
    private Reciever reciever;

    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
        this.sender = new Sender(s);
        this.reciever = new Reciever(s);
    }

    @Override
    public void run() {
        while(!s.isClosed()){
            try {
                Zahtev zahtev = (Zahtev) reciever.recieve();
                Odgovor odgovor = obradiKlijenta(zahtev);
                sender.send(odgovor);
            } catch (Exception ex) {
                if(s.isClosed()){
                    System.out.println("Zatvoren klijentski soket od strane servera!");
                } else {
                    System.out.println("Klijent se sam odvezao!");
                    return;
                }
            }
        }
    }

    private Odgovor obradiKlijenta(Zahtev zahtev) {
        switch (zahtev.getOperacija()) {
            case LOGIN:
                return login(zahtev);
            case VRATI_PENJACE:
                return vratiPenjace(zahtev);
            case VRATI_KATEGORIJE:
                return vratiKategorije(zahtev);
            case KREIRAJ_PENJAC:
                return kreirajPenjaca(zahtev);
            case PROMENI_PENJAC:
                return promeniPenjaca(zahtev);
            case OBRISI_PENJAC:
                return obrisiPenjaca(zahtev);
            case PRETRAZI_PENJAC:
                return pretraziPenjace(zahtev);
            case VRATI_RACUNE:
                return vratiRacune(zahtev);
            case VRATI_ZAPOSLENE:
                return vratiZaposlene(zahtev);
            case VRATI_USLUGE:
                return vratiUsluge(zahtev);
            case KREIRAJ_RACUN:
                return kreirajRacun(zahtev);
            case PROMENI_RACUN:
                return promeniRacun(zahtev);
            case PRETRAZI_RACUN:
                return pretraziRacune(zahtev);
            case UBACI_SMENA:
                return ubaciSmenu(zahtev);
            default:
                throw new AssertionError();
        }
    }

    public Socket getS() {
        return s;
    }

    void zaustaviNit() {
        if(s != null && !s.isClosed()){
            try {
                s.close();
            } catch (IOException ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Odgovor login(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        try {
            Zaposleni z = ControllerServer.getInstance().login((Zaposleni) zahtev.getParametar());
            System.out.println("Uspesna prijava na sistem...");
            odgovor.setOdgovor(z); // postaviti zapolsenog zbogliste zaposlenih
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor vratiPenjace(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<Penjac> penjaci = ControllerServer.getInstance().vratiPenjace();
            System.out.println("Uspesno ucitana lista penjaca...");
            odgovor.setOdgovor(penjaci);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor vratiKategorije(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<Kategorija> kategorije = ControllerServer.getInstance().vratiKategorije();
            System.out.println("Uspesno ucitana lista kategorija...");
            odgovor.setOdgovor(kategorije);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor kreirajPenjaca(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Penjac p = (Penjac) zahtev.getParametar();
        try {
            ControllerServer.getInstance().kreirajPenjaca(p);
            System.out.println("Uspeno kreiran novi penjac...");
            odgovor.setOdgovor(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor promeniPenjaca(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Penjac p = (Penjac) zahtev.getParametar();
        try {
            ControllerServer.getInstance().promeniPenjaca(p);
            System.out.println("Uspeno promenjen penjac...");
            odgovor.setOdgovor(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor obrisiPenjaca(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Penjac p = (Penjac) zahtev.getParametar();
        try {
            ControllerServer.getInstance().obrisiPenjaca(p);
            System.out.println("Uspeno obrisan penjac...");
            odgovor.setOdgovor(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor pretraziPenjace(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Penjac p = (Penjac) zahtev.getParametar();
        try {
            List<Penjac> penjaci = ControllerServer.getInstance().pretraziPenjace(p);
            System.out.println("Uspeno pretrazeni penjaci...");
            odgovor.setOdgovor(penjaci);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor vratiRacune(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<Racun> racuni = ControllerServer.getInstance().vratiRacune();
            System.out.println("Uspesno ucitana lista racuna...");
            odgovor.setOdgovor(racuni);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor vratiZaposlene(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<Zaposleni> zaposleni = ControllerServer.getInstance().vratiZaposlene();
            System.out.println("Uspesno ucitana lista zaposlenih...");
            odgovor.setOdgovor(zaposleni);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor vratiUsluge(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        try {
            List<Usluga> usluge = ControllerServer.getInstance().vratiUsluge();
            System.out.println("Uspesno ucitana lista usluga...");
            odgovor.setOdgovor(usluge);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor kreirajRacun(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Racun r = (Racun) zahtev.getParametar();
        try {
            ControllerServer.getInstance().kreirajRacun(r);
            System.out.println("Uspeno kreiran novi racun...");
            odgovor.setOdgovor(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor promeniRacun(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Racun r = (Racun) zahtev.getParametar();
        try {
            ControllerServer.getInstance().promeniRacun(r);
            System.out.println("Uspeno promenjen racun...");
            odgovor.setOdgovor(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor pretraziRacune(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Racun r = (Racun) zahtev.getParametar();
        try {
            List<Racun> racuni = ControllerServer.getInstance().pretraziRacune(r);
            System.out.println("Uspeno pretrazeni racuni...");
            odgovor.setOdgovor(racuni);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }

    private Odgovor ubaciSmenu(Zahtev zahtev) {
        Odgovor odgovor = new Odgovor();
        
        Smena s = (Smena) zahtev.getParametar();
        try {
            ControllerServer.getInstance().ubaciSmenu(s);
            System.out.println("Uspeno ubacena smena...");
            odgovor.setOdgovor(null);
        } catch (Exception ex) {
            ex.printStackTrace();
            odgovor.setEx(ex);
        }
        
        return odgovor;
    }
}
