/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Racun {
    private int idRacun;
    private Zaposleni zaposleni;
    private Penjac penjac;
    private LocalDateTime datumVreme;
    private double ukupanIznos;
    private List<StavkaRacuna> stavkeRacuna = new ArrayList<>();

    public Racun() {
    }

    public Racun(int id, Zaposleni zaposleni, Penjac penjac, LocalDateTime datumVreme, double ukupanIznos) {
        this.idRacun = id;
        this.zaposleni = zaposleni;
        this.penjac = penjac;
        this.datumVreme = datumVreme;
        this.ukupanIznos = ukupanIznos;
    }

    public int getId() {
        return idRacun;
    }

    public void setId(int id) {
        this.idRacun = id;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Penjac getPenjac() {
        return penjac;
    }

    public void setPenjac(Penjac penjac) {
        this.penjac = penjac;
    }

    public LocalDateTime getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(LocalDateTime datumVreme) {
        this.datumVreme = datumVreme;
    }

    public double getUkupanIznos() {
        return ukupanIznos;
    }

    public void setUkupanIznos(double ukupanIznos) {
        this.ukupanIznos = ukupanIznos;
    }

    public List<StavkaRacuna> getStavkeRacuna() {
        return stavkeRacuna;
    }

    public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
        this.stavkeRacuna = stavkeRacuna;
    }
}
