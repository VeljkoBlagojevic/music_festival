/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.concert;

import domain.Concert;
import exception.ConcertNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FindAllConcertsFiltered extends AbstractGenericOperation {

    private List<Concert> concerts = new ArrayList<>();

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Concert)) {
            throw new Exception("Ulazni parametar nije tipa Concert");
        }
        Concert concert = (Concert) param;
        if (concert == null) {
            throw new Exception("Passed parameter is null");
        }
        if (concert.getBand() == null || concert.getBand().getName() == null) {
            throw new Exception("Invalid band info passed");
        }
        if (concert.getStage() == null || concert.getStage().getName() == null) {
            throw new Exception("Invalid stage info passed");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Concert searchConcertParam = (Concert) param;

        concerts = ((List<Concert>) repository.findAll(param, FetchType.LAZY)).stream()
                .filter(concert -> concert.getBand().getName().contains(searchConcertParam.getBand().getName()))
                .filter(concert -> concert.getStage().getName().contains(searchConcertParam.getStage().getName()))
                .collect(Collectors.toList());
        
        if (concerts.isEmpty()) {
            throw new ConcertNotFoundException();
        }
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

}
