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
public class Penjac implements OpstiDomenskiObjekat{
    private Long idPenjac;
    private String ime;
    private String prezime;
    private int godine;
    private String email;
    private Kategorija kategorija;

    public Penjac() {
    }

    public Penjac(Long idPenjac, String ime, String prezime, int godine, String email, Kategorija kategorija) {
        this.idPenjac = idPenjac;
        this.ime = ime;
        this.prezime = prezime;
        this.godine = godine;
        this.email = email;
        this.kategorija = kategorija;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public Long getIdPenjac() {
        return idPenjac;
    }

    public void setId(Long idPenjac) {
        this.idPenjac = idPenjac;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Penjac other = (Penjac) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String toString() {
        return "Penjac{" + "id=" + idPenjac + ", ime=" + ime + ", prezime=" + prezime + ", godine=" + godine + ", email=" + email + ", kategorija=" + kategorija + '}';
    }

    @Override
    public String vratiNazivTabele() {
        return "penjac";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "ime, prezime, godine, email, kategorija";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("', ")
          .append("'").append(prezime).append("', ")
          .append(godine).append(", ")
          .append("'").append(email).append("', ")
          .append("'").append(kategorija.getIdKategorija()).append("'"); 
        return sb.toString();
    }
    
    @Override
    public void postaviId(Long id) {
        this.idPenjac = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("ime = '").append(ime).append("', ")
          .append("prezime = '").append(prezime).append("', ")
          .append("godine = ").append(godine).append(", ")
          .append("email = '").append(email).append("', ")
          .append("kategorija = ").append(kategorija.getIdKategorija());
        return sb.toString();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idPenjac = " + idPenjac;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long idPenjac = rs.getLong("idPenjac");
            String ime = rs. getString("ime");
            String prezime = rs. getString("prezime");
            int godine = rs.getInt("godine");
            String email = rs.getString("email");
            
            Long idKategorija = rs.getLong("idKategorija");
            String naziv = rs.getString("naziv");
            
            Kategorija k = new Kategorija(idKategorija, naziv);
            
            lista.add(new Penjac(idPenjac, ime, prezime, godine, email, k));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long idPenjac = rs.getLong("idPenjac");
            String ime = rs. getString("ime");
            String prezime = rs. getString("prezime");
            int godine = rs.getInt("godine");
            String email = rs.getString("email");
           
            Long idKategorija = rs.getLong("idKategorija");
            String naziv = rs.getString("naziv");
            
            Kategorija k = new Kategorija(idKategorija, naziv);
            
            return new Penjac(idPenjac, ime, prezime, godine, email, k);
        }
        return null;
    }
}
