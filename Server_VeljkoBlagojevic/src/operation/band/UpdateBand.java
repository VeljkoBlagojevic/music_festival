/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.band;

import domain.Band;
import operation.AbstractGenericOperation;

/**
 *
 * @author VeljkoBlagojevic
 */
public class UpdateBand extends AbstractGenericOperation {

    private boolean successful = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Band)) {
            throw new Exception("Parameter is not a type of  Band");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.update(param);
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }

}
