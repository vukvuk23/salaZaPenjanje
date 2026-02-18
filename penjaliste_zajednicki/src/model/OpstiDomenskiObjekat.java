/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface OpstiDomenskiObjekat extends Serializable{
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws Exception; 
    public String vratiNazivTabele();   
    public String vratiKoloneZaInsert();      
    public String vratiVrednostiZaInsert();    
    public String vratiPrimarniKljuc();      
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception;   
    public String vratiVrednostiZaUpdate(); 
}
