/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.concert;

import domain.Concert;
import domain.SongPerformance;
import operation.AbstractGenericOperation;

/**
 *
 * @author VeljkoBlagojevic
 */
public class DeleteConcert extends AbstractGenericOperation {

    private boolean successful = false;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Concert)) {
            throw new Exception("Parameter is not a type of  Concert");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Concert concert = (Concert) param;
        repository.deleteAll(new SongPerformance(), concert.getSetlist());
        repository.delete(concert);
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }

}
