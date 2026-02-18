/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Administrator
 */
public class StavkaRacuna {
    private int rbr;
    private Racun racun;
    private int kolicina;
    private double cena;
    private double iznos;
    private Usluga usluga;
    
    
    public StavkaRacuna() {
    }
    
    public StavkaRacuna(int rbr, Racun racun, int kolicina, double cena, double iznos, Usluga usluga ) {
        this.rbr = rbr;
        this.racun = racun;
        this.kolicina = kolicina;
        this.cena = cena;
        this.iznos = iznos;
        this.usluga = usluga;
    }

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Usluga getUsluga() {
        return usluga;
    }

    public void setUsluga(Usluga usluga) {
        this.usluga = usluga;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    @Override
    public String toString() {
        return "StavkaRacuna{" + "rbr=" + rbr + ", kolicina=" + kolicina + ", cena=" + cena + ", iznos=" + iznos + ", usluga=" + usluga + ", racun=" + racun + '}';
    }
}
