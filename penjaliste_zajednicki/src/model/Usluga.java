/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Usluga implements OpstiDomenskiObjekat {
    private Long idUsluga;
    private String naziv;
    private double cena;

    public Usluga() {
    }

    public Usluga(Long idUsluga, String naziv, double cena) {
        this.idUsluga = idUsluga;
        this.naziv = naziv;
        this.cena = cena;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Long getIdUsluga() {
        return idUsluga;
    }

    public void setIdUsluga(Long idUsluga) {
        this.idUsluga = idUsluga;
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

    @Override
    public String vratiNazivTabele() {
        return "usluga";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "naziv, cena";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naziv).append("', ")
          .append(cena);
        return sb.toString();
    }

    @Override
    public void postaviId(Long id) {
        this.idUsluga = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
       StringBuilder sb = new StringBuilder();
        sb.append("naziv = '").append(naziv).append("', ")
          .append("cena = ").append(cena);
        return sb.toString();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idUsluga = " + idUsluga;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long idUsluga = rs.getLong("idUsluga");
            String naziv = rs.getString("naziv");
            double cena = rs.getDouble("cena");
            
            lista.add(new Usluga(idUsluga, naziv, cena));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long idUsluga = rs.getLong("idUsluga");
            String naziv = rs.getString("naziv");
            double cena = rs.getDouble("cena");
            return new Usluga(idUsluga, naziv, cena);
        }
        return null;
    }
}
