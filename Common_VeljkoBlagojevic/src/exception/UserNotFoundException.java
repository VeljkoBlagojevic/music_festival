/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

import domain.User;


/**
 *
 * @author VeljkoBlagojevic
 */
public class UserNotFoundException extends EntityNotFoundException {
    
    public UserNotFoundException() {
        super(User.class);
    }
    
}
