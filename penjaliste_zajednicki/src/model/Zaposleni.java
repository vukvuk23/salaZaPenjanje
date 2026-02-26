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
public class Zaposleni implements OpstiDomenskiObjekat { 
    private Long idZaposleni;
    private String ime;
    private String prezime;
    private String email;
    private String brTelefona;
    private String lozinka;

    public Zaposleni() {
    }

    public Zaposleni(Long idZaposleni, String ime, String prezime, String email, String brTelefona, String lozinka) {
        this.idZaposleni = idZaposleni;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brTelefona = brTelefona;
        this.lozinka = lozinka;
    }

    public Long getIdZaposleni() {
        return idZaposleni;
    }

    public void setIdZaposleni(Long idZaposleni) {
        this.idZaposleni = idZaposleni;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrTelefona() {
        return brTelefona;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "Zaposleni{" + "id=" + idZaposleni + ", ime=" + ime + ", prezime=" + prezime + ", email=" + email + ", brTelefona=" + brTelefona + ", lozinka=" + lozinka + '}';
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
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "ime, prezime, email, brTelefona, lozinka";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(ime).append("', ")
          .append("'").append(prezime).append("', ")
          .append("'").append(email).append("', ")
          .append("'").append(brTelefona).append("', ")
          .append("'").append(lozinka).append("'");
        return sb.toString();
    }

    @Override
    public void postaviId(Long id) {
        this.idZaposleni = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("ime = '").append(ime).append("', ")
          .append("prezime = '").append(prezime).append("', ")
          .append("email = '").append(email).append("', ")
          .append("brTelefona = '").append(brTelefona).append("', ")
          .append("lozinka = '").append(lozinka).append("'");
        return sb.toString();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idZaposleni = " + idZaposleni;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long idZaposleni = rs.getLong("idZaposleni");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String email = rs.getString("email");
            String brTelefona = rs.getString("brTelefona");
            String lozinka = rs.getString("lozinka");

            lista.add(new Zaposleni(idZaposleni, ime, prezime, email, brTelefona, lozinka));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long idZaposleni = rs.getLong("idZaposleni");
            String ime = rs.getString("ime");
            String prezime = rs.getString("prezime");
            String email = rs.getString("email");
            String brTelefona = rs.getString("brTelefona");
            String lozinka = rs.getString("lozinka");

            return new Zaposleni(idZaposleni, ime, prezime, email, brTelefona, lozinka);
        }
        return null;
    }
}
