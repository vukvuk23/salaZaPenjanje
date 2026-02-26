/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class StavkaRacuna implements OpstiDomenskiObjekat {
    private Long rbr;
    private Racun racun;
    private int kolicina;
    private double cena;
    private double iznos;
    private Usluga usluga;
    
    
    public StavkaRacuna() {
    }
    
    public StavkaRacuna(Long rbr, Racun racun, int kolicina, double cena, double iznos, Usluga usluga ) {
        this.rbr = rbr;
        this.racun = racun;
        this.kolicina = kolicina;
        this.cena = cena;
        this.iznos = iznos;
        this.usluga = usluga;
    }

    public Long getRbr() {
        return rbr;
    }

    public void setRbr(Long rbr) {
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

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "racun, kolicina, cena, iznos, usluga";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append(racun.getIdRacun()).append(", ")
          .append(kolicina).append(", ")
          .append(cena).append(", ")
          .append(iznos).append(", ")
          .append(usluga.getIdUsluga());
        return sb.toString();
    }

    @Override
    public void postaviId(Long id) {
        this.rbr = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("kolicina = ").append(kolicina).append(", ")
          .append("cena = ").append(cena).append(", ")
          .append("iznos = ").append(iznos).append(", ")
          .append("usluga = ").append(usluga.getIdUsluga());
        return sb.toString();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "rbr = " + rbr; // hmmm
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long rbr = rs.getLong("stavkaracuna.rbr");
            int kolicina = rs.getInt("stavkaracuna.kolicina");
            double cena = rs.getDouble("stavkaracuna.cena");
            double iznos = rs.getDouble("stavkaracuna.iznos");

            Long idUsluga = rs.getLong("usluga.idUsluga");
            String nazivUsluga = rs.getString("usluga.naziv");
            double cenaUsluga = rs.getDouble("usluga.cena");
            
            Usluga u = new Usluga(idUsluga, nazivUsluga, cenaUsluga);

            Racun r = new Racun();
            r.setIdRacun(rs.getLong("stavkaracuna.racun"));
            
            lista.add(new StavkaRacuna(rbr, r, kolicina, cena, iznos, u));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long rbr = rs.getLong("stavkaracuna.rbr");
            int kolicina = rs.getInt("stavkaracuna.kolicina");
            double cena = rs.getDouble("stavkaracuna.cena");
            double iznos = rs.getDouble("stavkaracuna.iznos");

            Long idUsluga = rs.getLong("usluga.idUsluga");
            String nazivUsluga = rs.getString("usluga.naziv");
            double cenaUsluga = rs.getDouble("usluga.cena");
            
            Usluga u = new Usluga(idUsluga, nazivUsluga, cenaUsluga);
            
            Racun r = new Racun();
            r.setIdRacun(rs.getLong("stavkaracuna.racun"));
            
            return new StavkaRacuna(rbr, r, kolicina, cena, iznos, u);
        }
        return null;
    }
}
