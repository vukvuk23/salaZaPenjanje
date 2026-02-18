/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Administrator
 */
public class Reciever {
    private Socket s;

    public Reciever(Socket s) {
        this.s = s;
    }
    
    private Object recieve() throws Exception{
        try {
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            return in.readObject();
        } catch (Exception e) {
            throw new Exception("Greska pri primanju objekta! " + e.getMessage());
        }
    }
}
