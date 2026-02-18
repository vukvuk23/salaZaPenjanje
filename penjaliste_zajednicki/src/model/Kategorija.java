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
public class Kategorija {
    private int idKategorija;
    private String naziv;

    public Kategorija() {
    }

    public Kategorija(int id, String naziv) {
        this.idKategorija = id;
        this.naziv = naziv;
    }

    public int getId() {
        return idKategorija;
    }

    public void setId(int id) {
        this.idKategorija = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "Kategorija{" + "id=" + idKategorija + ", naziv=" + naziv + '}';
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
}
