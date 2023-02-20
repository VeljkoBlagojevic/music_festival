/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author VeljkoBlagojevic
 */
public class EntityNotFoundException extends Exception {

    public EntityNotFoundException(Class<?> className) {
        super("ERROR: " + className.getName() + " not found");
    }

}
