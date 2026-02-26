/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Konfiguracija {
    private static Konfiguracija instance;
    private Properties properties;
            
    private Konfiguracija(){
        try {
            properties = new Properties();
            properties.load(new FileInputStream("C:\\Users\\Administrator\\Desktop\\repos\\ps\\penjaliste_server\\config\\config.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, "Greska prilikom ucitavanja config fajla!", ex);
        }
    }
    
    public static Konfiguracija getInstance(){
        if(instance == null) instance = new Konfiguracija();
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key, "N/A");
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }
    
    public void sacuvajIzmene(){
        try {
            properties.store(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\repos\\ps\\penjaliste_server\\config\\config.properties"), null);
        } catch (IOException ex) {
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, "Greska prilikom upisivanja u config fajl!", ex);
        }
    }
}
