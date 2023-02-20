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
public class SaveConcert extends AbstractGenericOperation {

    private Concert concert;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Concert)) {
            throw new Exception("Parameter is not a type of  Concert");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Concert receivedConcert = (Concert) param;
        concert = (Concert) repository.save(receivedConcert);
        repository.saveAll(new SongPerformance(), concert.getSetlist());
    }

    public Concert getConcert() {
        return concert;
    }

}
