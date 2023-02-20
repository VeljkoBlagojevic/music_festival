/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import domain.Concert;


/**
 *
 * @author VeljkoBlagojevic
 */
public class ConcertNotFoundException extends EntityNotFoundException {
    
    public ConcertNotFoundException() {
        super(Concert.class);
    }
    
}
