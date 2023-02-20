/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.concert;

import domain.Concert;
import domain.SongPerformance;
import java.util.List;
import java.util.stream.Collectors;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class UpdateConcert extends AbstractGenericOperation {

    private boolean successful = false;

    private Concert updatedConcert = new Concert();
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Concert)) {
            throw new Exception("Parameter is not a type of  Concert");
        }

        Concert concert = (Concert) param;
        if (concert.getSetlist().isEmpty()) {
            throw new Exception("Setlist cannot be empty");
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Concert concert = (Concert) param;
        System.out.println("Concert\n" + param);
        
        updatedConcert = concert;

        List<SongPerformance> dbAllSongPerformances = (List<SongPerformance>) repository.findAll(new SongPerformance(), FetchType.EAGER);
        System.out.println("dbAllSongPerformances\n" + dbAllSongPerformances);

        List<SongPerformance> dbConcertSetlist = dbAllSongPerformances.stream()
                .filter(dbSongPerformance -> dbSongPerformance.getConcert().getId().equals(concert.getId()))
                .collect(Collectors.toList());
        System.out.println("dbConcertSetlist\n" + dbConcertSetlist);

        List<SongPerformance> newlyAddedSongPerformances = concert.getSetlist()
                .stream()
                .filter(memorySongPerformance -> !dbConcertSetlist.contains(memorySongPerformance))
                .collect(Collectors.toList());
        System.out.println("newlyAddedSongPerformances\n" + newlyAddedSongPerformances);

//        List<SongPerformance> updatedSongPerformances = (List<SongPerformance>) dbConcertSetlist.stream()
//                .filter(dbConcertSongPerformance -> dbConcertSetlist.contains(dbConcertSongPerformance))
//                .collect(Collectors.toList());
        List<SongPerformance> deletedSongPerformances = (List<SongPerformance>) dbConcertSetlist.stream()
                .filter(dbConcertSongPerformance -> !concert.getSetlist().contains(dbConcertSongPerformance))
                .collect(Collectors.toList());
        System.out.println("deletedSongPerformances\n" + deletedSongPerformances);

        if (!newlyAddedSongPerformances.isEmpty()) {
            List<SongPerformance> newlyAddedSongPerformancesIntoDb = (List<SongPerformance>) repository.saveAll(new SongPerformance(), newlyAddedSongPerformances);
            System.out.println("Newly added with id:");
            newlyAddedSongPerformancesIntoDb.forEach(sp -> System.out.println("id" + sp.getId() + sp.toString() + "\n"));
        }
//        repository.updateAll(new SongPerformance(), updatedSongPerformances);
        if (!deletedSongPerformances.isEmpty()) {
            repository.deleteAll(new SongPerformance(), deletedSongPerformances);
        }

        updatedConcert = (Concert) repository.update(concert);
        successful = true;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public Concert getUpdatedConcert() {
        return updatedConcert;
    }

}
