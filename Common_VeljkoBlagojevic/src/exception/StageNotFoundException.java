/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import domain.Stage;


/**
 *
 * @author VeljkoBlagojevic
 */
public class StageNotFoundException extends EntityNotFoundException {
    
    public StageNotFoundException() {
        super(Stage.class);
    }
    
}
