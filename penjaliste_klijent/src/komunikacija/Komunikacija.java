/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class Komunikacija {
    private static Komunikacija instance;
    private Socket s;
    private Sender sender;
    private Reciever reciever;

    private Komunikacija() throws IOException {
        this.s = new Socket("localhost", 9000);
        this.sender = new Sender(s);
        this.reciever = new Reciever(s);
    }
    
    public static Komunikacija getInstance() throws IOException{
        if(instance == null) instance = new Komunikacija();
        return instance;
    }

    public Odgovor login(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Pslat zahtev za login...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor vratiPenjace(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za vracanje svih penjaca...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor vratiKategorije(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za vracanje svih kategorija...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor kreirajPenjaca(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za kreiranje novog penjaca...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor promeniPenjaca(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za promenu penjaca...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor obrisiPenjaca(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za brisanje penjaca...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor pretraziPenjace(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za pretrazivanje penjaca...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor vratiRacune(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za vracanje svih racuna...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor vratiZaposlene(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za vracanje svih zaposlenih...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor vratiUsluge(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za vracanje svih usluga...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor kreirajRacun(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za kreiranje novog racuna...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor izmeniRacun(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za promenu racuna...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor pretraziRacune(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za pretrazivanje racuna...");
        return (Odgovor) reciever.recieve();
    }

    public Odgovor ubaciSmenu(Zahtev zahtev) throws Exception {
        sender.send(zahtev);
        System.out.println("Poslat zahtev za ubacivanje smene...");
        return (Odgovor) reciever.recieve();
    }
}
