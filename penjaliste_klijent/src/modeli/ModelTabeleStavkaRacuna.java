/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.StavkaRacuna;

/**
 *
 * @author Administrator
 */
public class ModelTabeleStavkaRacuna extends AbstractTableModel {
    private List<StavkaRacuna> stavke;
    private String[] kolone = {"Naziv usluge", "Kolicina", "Cena usluge", "Iznos stavke"};
    
    public ModelTabeleStavkaRacuna(List<StavkaRacuna> stavke) {
        this.stavke = stavke;
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                return stavke.get(rowIndex).getUsluga().getNaziv();
            case 1: 
                return stavke.get(rowIndex).getKolicina();
            case 2: 
                return stavke.get(rowIndex).getCena();
            case 3: 
                return stavke.get(rowIndex).getIznos();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public List<StavkaRacuna> getStavke() {
        return stavke;
    }
}
