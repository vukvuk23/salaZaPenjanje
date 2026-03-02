/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import model.OpstiDomenskiObjekat;
import repository.Repository;
import repository.db.DbRepository;
import repository.db.impl.DbRepositoryGeneric;

/**
 *
 * @author Administrator
 */
public abstract class ApstraktnaSO {
    protected final Repository repository;

    public ApstraktnaSO() {
        this.repository = new DbRepositoryGeneric();
    }

    public void izvrsi(OpstiDomenskiObjekat odo) throws Exception {
        try {
            preduslov(odo);
            zapocniTransakciju();
            izvrsiOperaciju(odo);
            potvrdiTransakciju();
            System.out.println("Uspesno izvrsena operacija!");
        } catch (Exception ex) {
            System.out.println("Neuspesno izvrsena operacija!");
            ponistiTransakciju();
            throw ex;
        }// da li fali disconnect
    }

    protected abstract void preduslov(OpstiDomenskiObjekat odo) throws Exception;

    protected abstract void izvrsiOperaciju(OpstiDomenskiObjekat odo) throws Exception;

    private void zapocniTransakciju() throws Exception {
        ((DbRepository) repository).connect();
    }

    protected void potvrdiTransakciju() throws Exception {
        ((DbRepository) repository).commit();
    }

    protected void ponistiTransakciju() throws Exception {
        ((DbRepository) repository).rollback();
    }
}
