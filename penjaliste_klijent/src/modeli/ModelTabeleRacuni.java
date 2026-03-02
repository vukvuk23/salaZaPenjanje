/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Racun;

/**
 *
 * @author Administrator
 */
public class ModelTabeleRacuni extends AbstractTableModel {
    private List<Racun> racuni;
    private String[] kolone = {"Zaposleni", "Penjac", "Datum i vreme", "Ukupan iznos"};
    
    public ModelTabeleRacuni(List<Racun> racuni) {
        this.racuni = racuni;
    }
    
    @Override
    public int getRowCount() {
        return racuni.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: 
                return racuni.get(rowIndex).getZaposleni().getIme() + " " + racuni.get(rowIndex).getZaposleni().getPrezime();
            case 1: 
                return racuni.get(rowIndex).getPenjac().getIme() + " " + racuni.get(rowIndex).getPenjac().getPrezime();
            case 2: 
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
                return racuni.get(rowIndex).getDatumVreme().format(formatter);
            case 3: 
                return racuni.get(rowIndex).getUkupanIznos();
            default: 
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Racun> getRacuni() {
        return racuni;
    }
}
