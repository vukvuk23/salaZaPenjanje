/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Zaposleni { 
    private int idZaposleni;
    private String ime;
    private String prezime;
    private String email;
    private String brTelefona;
    private String lozinka;

    public Zaposleni() {
    }

    public Zaposleni(int id, String ime, String prezime, String email, String brTelefona, String lozinka) {
        this.idZaposleni = id;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brTelefona = brTelefona;
        this.lozinka = lozinka;
    }

    public int getId() {
        return idZaposleni;
    }

    public void setId(int id) {
        this.idZaposleni = id;
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
}
