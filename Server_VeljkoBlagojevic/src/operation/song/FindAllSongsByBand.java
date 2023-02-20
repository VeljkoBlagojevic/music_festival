/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.song;

import domain.Band;
import domain.Song;
import exception.SongNotFoundException;
import java.util.ArrayList;
import java.util.List;
import operation.AbstractGenericOperation;
import operation.FetchType;

/**
 *
 * @author VeljkoBlagojevic
 */
public class FindAllSongsByBand extends AbstractGenericOperation {

    private List<Song> songsByBand = new ArrayList<>();

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Band)) {
            throw new Exception("Parameter is not a type of  Band");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        List<Song> allSongs = (List<Song>) repository.findAll(new Song(), FetchType.LAZY);
        songsByBand = allSongs.stream()
                .filter(song -> song.getBand().equals(param))
                .toList();
        if (songsByBand.isEmpty()) {
            throw new SongNotFoundException();
        }
    }

    public List<Song> getSongsByBand() {
        return songsByBand;
    }

}
