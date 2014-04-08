/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Processing;

/**
 *
 * @author Tim
 */
public class ProcessorException extends Exception {
    private String message;
    ProcessorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
