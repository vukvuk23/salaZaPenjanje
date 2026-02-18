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
public class Usluga {
    private int idUsluga;
    private String naziv;
    private double cena;

    public Usluga() {
    }

    public Usluga(int id, String naziv, double cena) {
        this.idUsluga = id;
        this.naziv = naziv;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public int getId() {
        return idUsluga;
    }

    public void setId(int id) {
        this.idUsluga = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
        final Usluga other = (Usluga) obj;
        if (Double.doubleToLongBits(this.cena) != Double.doubleToLongBits(other.cena)) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String toString() {
        return "Usluga{" + "id=" + idUsluga + ", naziv=" + naziv + ", cena=" + cena + '}';
    }
}
