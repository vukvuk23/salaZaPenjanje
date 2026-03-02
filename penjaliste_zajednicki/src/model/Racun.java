/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class Racun implements OpstiDomenskiObjekat {
    private Long idRacun;
    private Zaposleni zaposleni;
    private Penjac penjac;
    private LocalDateTime datumVreme;
    private double ukupanIznos;
    private List<StavkaRacuna> stavkeRacuna = new ArrayList<>();

    public Racun() {
    }

    public Racun(Long idRacun, Zaposleni zaposleni, Penjac penjac, LocalDateTime datumVreme, double ukupanIznos) {
        this.idRacun = idRacun;
        this.zaposleni = zaposleni;
        this.penjac = penjac;
        this.datumVreme = datumVreme;
        this.ukupanIznos = ukupanIznos;
    }

    public Long getIdRacun() {
        return idRacun;
    }

    public void setIdRacun(Long idRacun) {
        this.idRacun = idRacun;
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

    public void izracunajUkupanIznos() {
        double iznos = 0;
        for (StavkaRacuna s : stavkeRacuna) {
            iznos += s.getIznos();
        }
        ukupanIznos = iznos;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public String vratiKoloneZaInsert() {
        return "zaposleni, penjac, datumVreme, ukupanIznos";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append(zaposleni.getIdZaposleni()).append(", ")
          .append(penjac.getIdPenjac()).append(", ")
          .append("'").append(datumVreme).append("', ")
          .append(ukupanIznos);
        return sb.toString();
    }

    @Override
    public void postaviId(Long id) {
        this.idRacun = id;
    }

    @Override
    public String vratiVrednostiZaUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("zaposleni = ").append(zaposleni.getIdZaposleni()).append(", ")
          .append("penjac = ").append(penjac.getIdPenjac()).append(", ")
          .append("datumVreme = '").append(datumVreme).append("', ")
          .append("ukupanIznos = ").append(ukupanIznos);
        return sb.toString();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "idRacun = " + idRacun;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuIzRS(ResultSet rs) throws Exception {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Long idPenjac = rs.getLong("p.idPenjac");
            String ime =  rs.getString("p.ime");
            String prezime = rs.getString("p.prezime");
            int godine = rs.getInt("p.godine");
            String email = rs.getString("p.email");
            
            Long idKategorija = rs.getLong("k.idKategorija");
            String naziv = rs.getString("k.naziv");
            
            Kategorija k = new Kategorija(idKategorija, naziv);
            Penjac p = new Penjac(idPenjac, ime, prezime, godine, email, k);
            
            Long idZaposleni = rs.getLong("z.idZaposleni");
            String imeZaposleni = rs.getString("z.ime");
            String prezimeZaposleni = rs.getString("z.prezime");
            String emailZaposleni = rs.getString("z.email");
            String brTelefona = rs.getString("z.brTelefona");
            String lozinka = rs.getString("z.lozinka");
            
            Zaposleni z = new Zaposleni(idZaposleni, imeZaposleni, prezimeZaposleni, emailZaposleni, brTelefona, lozinka);
            
            Long idRacun = rs.getLong("r.idRacun");
            LocalDateTime datumVreme = rs.getTimestamp("r.datumVreme").toLocalDateTime();
            double ukupanIznos = rs.getDouble("r.ukupanIznos");
            
            lista.add(new Racun(idRacun, z, p, datumVreme, ukupanIznos));
        }
        return lista;
    }

    @Override
    public OpstiDomenskiObjekat vratiObjekatIzRS(ResultSet rs) throws Exception {
        if (rs.next()) {
            Long idPenjac = rs.getLong("p.idPenjac");
            String ime =  rs.getString("p.ime");
            String prezime = rs.getString("p.prezime");
            int godine = rs.getInt("p.godine");
            String email = rs.getString("p.email");
            
            Long idKategorija = rs.getLong("k.idKategorija");
            String naziv = rs.getString("k.naziv");
            
            Kategorija k = new Kategorija(idKategorija, naziv);
            
            Penjac p = new Penjac(idPenjac, ime, prezime, godine, email, k);
            
            Long idZaposleni = rs.getLong("z.idZaposleni");
            String imeZaposleni = rs.getString("z.ime");
            String prezimeZaposleni = rs.getString("z.prezime");
            String emailZaposleni = rs.getString("z.email");
            String brTelefona = rs.getString("z.brTelefona");
            String lozinka = rs.getString("z.lozinka");
            
            Zaposleni z = new Zaposleni(idZaposleni, imeZaposleni, prezimeZaposleni, emailZaposleni, brTelefona, lozinka);
            
            Long idRacun = rs.getLong("r.idRacun");
            LocalDateTime datumVreme = rs.getTimestamp("r.datumVreme").toLocalDateTime();
            double ukupanIznos = rs.getDouble("r.ukupanIznos");
            
            return new Racun(idRacun, z, p, datumVreme, ukupanIznos);
        }
        return null;
    }

    @Override
    public String join() {
        return "JOIN zaposleni z ON r.zaposleni = z.idZaposleni JOIN penjac p ON r.penjac = p.idPenjac JOIN kategorija k ON k.idKategorija = p.kategorija";
    }

    @Override
    public String alias() {
        return " r ";
    }

    @Override
    public String uslovZaSelect() {
        StringBuilder sb = new StringBuilder();
    
        if (zaposleni != null) {
            sb.append("r.zaposleni = ").append(zaposleni.getIdZaposleni());
        }
        if (penjac != null) {
            if (sb.length() > 0) sb.append(" AND ");
            sb.append("r.penjac = ").append(penjac.getIdPenjac());
        }

        return sb.toString();
    }
}
