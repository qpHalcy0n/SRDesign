/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PostProcessing;

/**
 *
 * @author Tim
 */
public class PostProcessorException extends Exception {
    private String message;
    PostProcessorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    
}
