/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package transfer;

/**
 *
 * @author VeljkoBlagojevic
 */
public enum StatusCode {
    OK(200), CREATED(201), NO_CONTENT(204), BAD_REQUEST(400), NOT_FOUND(404);

    private int status;

    private StatusCode(int status) {
        this.status = status;
    }
}
