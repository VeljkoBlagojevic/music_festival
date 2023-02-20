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
public class FindAllBandsFiltered extends AbstractGenericOperation {

    private List<Band> bands = new ArrayList<>();

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Band)) {
            throw new Exception("Parameter is not a type of  User");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Band searchBandParam = (Band) param;

        bands = ((List<Band>) repository.findAll(param, FetchType.LAZY)).stream()
                .filter(band -> band.getName().contains(searchBandParam.getName()))
                .toList();

        if (bands.isEmpty()) {
            throw new BandNotFoundException();
        }

    }

    public List<Band> getBands() {
        return bands;
    }

}
