/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class Sender {
    private Socket s;

    public Sender(Socket s) {
        this.s = s;
    }
    
    public void send(Object o) throws Exception{
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(o);
            out.flush();
        } catch (Exception e) {
            throw new Exception("Greska pri slanju objekta! " + e.getMessage());
        }
    }
}
