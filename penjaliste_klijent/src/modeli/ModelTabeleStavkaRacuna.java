/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeli;

import java.util.List;
import javax.swing.JOptionPane;
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
    
//    @Override
//    public boolean isCellEditable(int row, int column) {
//        return column == 1;
//    }
//    
//    @Override
//    public void setValueAt(Object value, int row, int column) {
//        if (column == 1) {
//            try {
//                int kolicina = Integer.parseInt(value.toString());
//                if (kolicina <= 0) {
//                    JOptionPane.showMessageDialog(null, "Kolicina mora biti pozitivan broj!");
//                    return;
//                }
//                stavke.get(row).setKolicina(kolicina);
//                stavke.get(row).postaviIznos();
//                fireTableDataChanged();
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Kolicina mora biti ceo broj!");
//            }
//        }
//    }
}
