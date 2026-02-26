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
    public String vratiNazivTabele();   
    public String vratiKoloneZaInsert();      
    public String vratiVrednostiZaInsert(); 
    public void postaviId(Long id);    
    public String vratiVrednostiZaUpdate();
    public String vratiPrimarniKljuc();     
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception; 
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception;
}
