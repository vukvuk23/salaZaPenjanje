/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Reciever;
import komunikacija.Sender;
import komunikacija.Zahtev;

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
                Zahtev z = (Zahtev) reciever.recieve();
                Odgovor o = obradiKlijenta(z);
                sender.send(o);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Odgovor obradiKlijenta(Zahtev z) {
        Odgovor o = new Odgovor();
        
//        switch (var) {
//            case val:
//                
//                break;
//            default:
//                throw new AssertionError();
//        }
        //postaviti o.setEx !!!!!!!!!!!!!!
        return o;
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
}
