/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ZaposleniSmena implements OpstiDomenskiObjekat {
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

    @Override
    public String vratiNazivTabele() {
        return "zaposlensimena";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "zaposleni, smena, datum, napomena";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append(zaposleni.getIdZaposleni()).append(", ")
          .append(smena.getIdSmena()).append(", '")
          .append(datum).append("', '")
          .append(napomena).append("'");
        return sb.toString();
    }

    @Override
    public void postaviId(Long id) {
        
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("smena = ").append(smena.getIdSmena()).append(", ")
          .append("napomena = '").append(napomena).append("'");
        return sb.toString();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zaposleni = " + zaposleni.getIdZaposleni() + " AND smena = " + smena.getIdSmena() + " AND datum = '" + datum + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long idZaposleni = rs.getLong("z.idZaposleni");
            String ime = rs.getString("z.ime");
            String prezime = rs.getString("z.prezime");
            String email = rs.getString("z.email");
            String brTelefona = rs.getString("z.brTelefona");
            String lozinka = rs.getString("z.lozinka");
            Zaposleni z = new Zaposleni(idZaposleni, ime, prezime, email, brTelefona, lozinka);

            Long idSmena = rs.getLong("s.idSmena");
            String naziv = rs.getString("s.naziv");
            LocalTime vremeOd = rs.getTime("s.vremeOd").toLocalTime();
            LocalTime vremeDo = rs.getTime("s.vremeDo").toLocalTime();
            Smena s = new Smena(idSmena, naziv, vremeOd, vremeDo);

            LocalDate datum = rs.getDate("zs.datum").toLocalDate();
            String napomena = rs.getString("zs.napomena");

            lista.add(new ZaposleniSmena(z, s, datum, napomena));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long idZaposleni = rs.getLong("z.idZaposleni");
            String ime = rs.getString("z.ime");
            String prezime = rs.getString("z.prezime");
            String email = rs.getString("z.email");
            String brTelefona = rs.getString("z.brTelefona");
            String lozinka = rs.getString("z.lozinka");
            Zaposleni z = new Zaposleni(idZaposleni, ime, prezime, email, brTelefona, lozinka);

            Long idSmena = rs.getLong("s.idSmena");
            String naziv = rs.getString("s.naziv");
            LocalTime vremeOd = rs.getTime("s.vremeOd").toLocalTime();
            LocalTime vremeDo = rs.getTime("s.vremeDo").toLocalTime();
            Smena s = new Smena(idSmena, naziv, vremeOd, vremeDo);

            LocalDate datum = rs.getDate("zs.datum").toLocalDate();
            String napomena = rs.getString("zs.napomena");

            return new ZaposleniSmena(z, s, datum, napomena);
        }
        return null;
    }

    @Override
    public String join() {
        return " JOIN zaposleni z ON zs.zaposleni = z.idZaposleni JOIN smena s ON zs.smena = s.idSmena ";
    }

    @Override
    public String alias() {
        return " zs ";
    }

    @Override
    public String uslovZaSelect() {
        return "";
    }
}
