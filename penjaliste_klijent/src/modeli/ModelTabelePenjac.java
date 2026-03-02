/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Penjac;

/**
 *
 * @author Administrator
 */
public class ModelTabelePenjac extends AbstractTableModel {
    private List<Penjac> penjaci;
    private String[] kolone = {"Ime", "Prezime", "Godine", "Email", "Kategorija"};
     
    public ModelTabelePenjac(List<Penjac> penjaci) {
        this.penjaci = penjaci;
    }
    
    @Override
    public int getRowCount() {
        return penjaci.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: 
                return penjaci.get(rowIndex).getIme();
            case 1: 
                return penjaci.get(rowIndex).getPrezime();
            case 2: 
                return penjaci.get(rowIndex).getGodine();
            case 3: 
                return penjaci.get(rowIndex).getEmail();
            case 4: 
                return penjaci.get(rowIndex).getKategorija().getNaziv();
            default: 
                return "N/A";
        }
         
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Penjac> getPenjaci() {
        return penjaci;
    }
}
