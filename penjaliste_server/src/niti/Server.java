/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Server extends Thread{

    private ServerSocket serverskiSocket;
    private List<ObradaKlijentskihZahteva> niti = new ArrayList<>();
    
    @Override
    public void run() {
        try {
            serverskiSocket = new ServerSocket(9000);
            System.out.println("Server je pokrenut! Cekaju se klijetni...");
            while(!serverskiSocket.isClosed()){
                Socket s = serverskiSocket.accept();
                System.out.println("Klijent povezan!");
                
                ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(s);
                nit.start();
                niti.add(nit);
            }
        } catch (IOException ex) {
            if(serverskiSocket.isClosed()){
                System.out.println("Server je zaustavljen!");
            }else{
                ex.printStackTrace();
            }
        }
    }
    
    private void zaustaviNiti(){
        for (ObradaKlijentskihZahteva nit : niti) {
            nit.zaustaviNit();
        }
    }

    public void zaustavi() {
        if(serverskiSocket != null && !serverskiSocket.isClosed()){
            try {
                serverskiSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
