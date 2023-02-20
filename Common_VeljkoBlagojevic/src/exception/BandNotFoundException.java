/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import domain.Band;

/**
 *
 * @author VeljkoBlagojevic
 */
public class BandNotFoundException extends EntityNotFoundException {
    
    public BandNotFoundException() {
        super(Band.class);
    }
    
}
