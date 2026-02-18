/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Administrator
 */
public class ZaposleniSmena {
    private Zaposleni zaposleni;
    private Smena smena;
    private LocalDate datum;
    private String napomena;

    public ZaposleniSmena() {
    }

    public ZaposleniSmena(Zaposleni zaposleni, Smena smena, LocalDate datum, String napomena) {
        this.zaposleni = zaposleni;
        this.smena = smena;
        this.datum = datum;
        this.napomena = napomena;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Smena getSmena() {
        return smena;
    }

    public void setSmena(Smena smena) {
        this.smena = smena;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }
}
