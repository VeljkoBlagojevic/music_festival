/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.song;

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
public class FindAllSongs extends AbstractGenericOperation {

    private List<Song> songs = new ArrayList<>();

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Song)) {
            throw new Exception("Parameter is not a type of  Song");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        songs = (List<Song>) repository.findAll(param, FetchType.LAZY);
        if(songs.isEmpty()) {
            throw new SongNotFoundException();
        }
    }

    public List<Song> getSongs() {
        return songs;
    }

}
