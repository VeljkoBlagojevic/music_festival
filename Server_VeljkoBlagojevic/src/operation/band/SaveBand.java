/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.band;

import domain.Band;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class SaveBand extends AbstractGenericOperation {

    private Band band;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Band)) {
            throw new Exception("Parameter is not a type of  User");
        }

        List<Band> dbBands = (List<Band>) repository.findAll(new Band(), FetchType.LAZY);
        if (dbBands.stream().anyMatch(dbBand -> dbBand.getName().equals(param))) {
            throw new Exception("There already a band with same name in database!");
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        band = (Band) repository.save(param);
    }

    public Band getBand() {
        return band;
    }

}
