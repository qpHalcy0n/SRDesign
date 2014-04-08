/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Preprocessing;

/**
 *
 * @author Tim
 */
public class PreprocessorException extends Exception {
    private String message;
    PreprocessorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
