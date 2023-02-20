/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.band;

import domain.Band;
import exception.BandNotFoundException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FindAllBands extends AbstractGenericOperation {

    private List<Band> bands = new ArrayList<>();

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Band)) {
            throw new Exception("Parameter is not a type of  User");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        bands = (List<Band>) repository.findAll(param, FetchType.LAZY);
        if (bands.isEmpty()) {
            throw new BandNotFoundException();
        }
    }

    public List<Band> getBands() {
        return bands;
    }

}
