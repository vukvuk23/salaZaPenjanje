/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Smena implements OpstiDomenskiObjekat {
    private Long idSmena;
    private String naziv;
    private LocalTime vremeOd;
    private LocalTime vremeDo;

    public Smena() {
    }

    public Smena(Long idSmena, String naziv, LocalTime vremeOd, LocalTime vremeDo) {
        this.idSmena = idSmena;
        this.naziv = naziv;
        this.vremeOd = vremeOd;
        this.vremeDo = vremeDo;
    }

    public Long getIdSmena() {
        return idSmena;
    }

    public void setIdSmena(Long idSmena) {
        this.idSmena = idSmena;
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

    @Override
    public String vratiNazivTabele() {
        return "smena";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "naziv, vremeOd, vremeDo";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("', '")
          .append(vremeOd).append("', '")
          .append(vremeDo).append("'");
        return sb.toString();
    }

    @Override
    public void postaviId(Long id) {
        this.idSmena = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("naziv = '").append(naziv).append("', ")
          .append("vremeOd = '").append(vremeOd).append("', ")
          .append("vremeDo = '").append(vremeDo).append("'");
        return sb.toString();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idSmena = " + idSmena;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long idSmena = rs.getLong("idSmena");
            String naziv = rs.getString("naziv");
            LocalTime vremeOd = rs.getTime("vremeOd").toLocalTime();
            LocalTime vremeDo = rs.getTime("vremeDo").toLocalTime();
            
            lista.add(new Smena(idSmena, naziv, vremeOd, vremeDo));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long idSmena = rs.getLong("idSmena");
            String naziv = rs.getString("naziv");
            LocalTime vremeOd = rs.getTime("vremeOd").toLocalTime();
            LocalTime vremeDo = rs.getTime("vremeDo").toLocalTime();
            
            return new Smena(idSmena, naziv, vremeOd, vremeDo);
        }
        return null;
    }
}
