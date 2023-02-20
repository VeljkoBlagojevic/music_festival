/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operation.song;

import domain.Song;
import operation.AbstractGenericOperation;

/**
 *
 * @author VeljkoBlagojevic
 */
public class SaveSong extends AbstractGenericOperation {

    private Song song;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Song)) {
            throw new Exception("Parameter is not a type of  Song");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        song = (Song) repository.save(param);
    }

    public Song getSong() {
        return song;
    }

}
