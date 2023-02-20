/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.concert;

import domain.Concert;
import exception.ConcertNotFoundException;
import java.util.Optional;
import operation.AbstractGenericOperation;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FindConcertById extends AbstractGenericOperation {

    private Concert concert;
    private Optional<Concert> optionalConcert;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Long)) {
            throw new Exception("Parameter is not a type of  Long");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        optionalConcert = repository.findByID(new Concert(), param);
        if (optionalConcert.isEmpty()) {
            throw new ConcertNotFoundException();
        }
        concert = optionalConcert.get();
    }

    public Concert getConcert() {
        return concert;
    }

}
