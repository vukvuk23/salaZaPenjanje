/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.util.List;
import model.OpstiDomenskiObjekat;
import repository.db.DbRepository;
import java.sql.SQLException;
import java.sql.Connection;
import repository.db.DbConnectionFactory;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Administrator
 */
public class DbRepositoryGeneric implements DbRepository<OpstiDomenskiObjekat>{

    @Override
    public List<OpstiDomenskiObjekat> getAll(OpstiDomenskiObjekat odo, String uslov) throws Exception {// nemamo where u uslovu
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append(odo.vratiNazivTabele());
            if (uslov != null && !uslov.isEmpty()) {
                sb.append(uslov); // da li da ovde dodam where, ali i da dodam odo.join() metodu
            }
            String upit = sb.toString();
            System.out.println(upit);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            List<OpstiDomenskiObjekat> lista = odo.vratiListuIzRS(rs);
            st.close();
            rs.close();
            return lista;
        } catch (SQLException ex) {
            System.out.println("Greska pri metodi getAll: " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void add(OpstiDomenskiObjekat odo) throws Exception { // mozda moze da vrati Long id
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();// nije thread safe
            sb.append("INSERT INTO ").append(odo.vratiNazivTabele())
              .append("(").append(odo.vratiKoloneZaInsert()).append(")")
              .append(" VALUES (").append(odo.vratiVrednostiZaInsert()).append(")");
            String upit = sb.toString();
            System.out.println(upit);
            Statement st = connection.createStatement();
            st.executeUpdate(upit, Statement.RETURN_GENERATED_KEYS);// br redova na koje je naredba uticala
            ResultSet rsKey = st.getGeneratedKeys();
            if(rsKey.next()){
                Long id = rsKey.getLong(1);// unapredjeni long, dodaci za null i parse
                odo.postaviId(id);
            }
            rsKey.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println("Greska pri metodi add: " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void edit(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ").append(odo.vratiNazivTabele())
              .append(" SET ").append(odo.vratiVrednostiZaUpdate())
              .append(" WHERE ").append(odo.vratiPrimarniKljuc());
            String upit = sb.toString();
            System.out.println(upit);
            Statement st = connection.createStatement();
            st.executeUpdate(upit);
            st.close();
        } catch (SQLException ex) {
            System.out.println("Greska pri metodi edit: " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void delete(OpstiDomenskiObjekat odo) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM ").append(odo.vratiNazivTabele())
              .append(" WHERE ").append(odo.vratiPrimarniKljuc());
            String upit = sb.toString();
            System.out.println(upit);
            Statement st = connection.createStatement();
            st.executeUpdate(upit);
            st.close();
        } catch (SQLException ex) {
            System.out.println("Greska pri metodi delete: " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public OpstiDomenskiObjekat get(OpstiDomenskiObjekat odo, String uslov) throws Exception {
        try {
            Connection connection = DbConnectionFactory.getInstance().getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM ").append(odo.vratiNazivTabele())
              .append(uslov);
            String upit = sb.toString();
            System.out.println(upit);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(upit);
            OpstiDomenskiObjekat rez = odo.vratiObjekatIzRS(rs);
            rs.close();
            st.close();
            return rez;
        } catch (SQLException ex) {
            System.out.println("Greska pri metodi get: " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
}
