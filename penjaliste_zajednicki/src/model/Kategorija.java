/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Kategorija implements OpstiDomenskiObjekat {
    private Long idKategorija;
    private String naziv;

    public Kategorija() {
    }

    public Kategorija(Long idKategorija, String naziv) {
        this.idKategorija = idKategorija;
        this.naziv = naziv;
    }

    public Long getIdKategorija() {
        return idKategorija;
    }

    public void setIdKategorija(Long idKategorija) {
        this.idKategorija = idKategorija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Kategorija{" + "idKategorija=" + idKategorija + ", naziv=" + naziv + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kategorija other = (Kategorija) obj;
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String vratiNazivTabele() {
         return "kategorija";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "naziv";
    }

    @Override
    public String vratiVrednostiZaInsert() {
         return "'" + naziv + "'";
    }

    @Override
    public void postaviId(Long id) {
        this.idKategorija = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        return "naziv = '" + naziv + "'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idKategorija = " + idKategorija;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long idKategorija = rs.getLong("idKategorija");
            String naziv = rs.getString("naziv");
            
            lista.add(new Kategorija(idKategorija, naziv));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long idKategorija = rs.getLong("idKategorija");
            String naziv = rs.getString("naziv");
            
            return new Kategorija(idKategorija, naziv);
        }
        return null;
    }
}
