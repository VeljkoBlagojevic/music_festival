/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.concert;

import domain.Concert;
import exception.ConcertNotFoundException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FindAllConcerts extends AbstractGenericOperation {

    private List<Concert> concerts = new ArrayList<>();

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Concert)) {
            throw new Exception("Ulazni parametar nije tipa Concert");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        concerts = (List<Concert>) repository.findAll(param, FetchType.LAZY);
        if (concerts.isEmpty()) {
            throw new ConcertNotFoundException();
        }
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

}
