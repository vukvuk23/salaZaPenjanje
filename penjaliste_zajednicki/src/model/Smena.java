/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author Administrator
 */
public class Smena {
    private int idSmena;
    private String naziv;
    private LocalTime vremeOd;
    private LocalTime vremeDo;

    public Smena() {
    }

    public Smena(int id, String naziv, LocalTime vremeOd, LocalTime vremeDo) {
        this.idSmena = id;
        this.naziv = naziv;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
    }

    public int getId() {
        return idSmena;
    }

    public void setId(int id) {
        this.idSmena = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public LocalTime getVremeOd() {
        return vremeOd;
    }

    public void setVremeOd(LocalTime vremeOd) {
        this.vremeOd = vremeOd;
    }

    public LocalTime getVremeDo() {
        return vremeDo;
    }

    public void setVremeDo(LocalTime vremeDo) {
        this.vremeDo = vremeDo;
    }
}
