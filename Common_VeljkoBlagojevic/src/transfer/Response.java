/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author student2
 */

@DTO
public class Response implements Serializable {

    private final Object result;
    private final Exception exception;
    private final StatusCode statusCode;


    public Response(Object result, Exception exception, StatusCode statusCode) {
        this.result = result;
        this.exception = exception;
        this.statusCode = statusCode;
    }

    public Object getResult() {
        return result;
    }

    public Exception getException() {
        return exception;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

}
