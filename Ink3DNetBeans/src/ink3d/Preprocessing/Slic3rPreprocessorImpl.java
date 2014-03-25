/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Preprocessing;

import ink3d.ConfigurationObjects.PrintJobConfiguration;

/**
 *
 * @author Tim
 */
public class Slic3rPreprocessorImpl implements Preprocessor {

    @Override
    public boolean preprocess(PrintJobConfiguration printJobConfiguration) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private boolean normalize(PrintJobConfiguration printJobConfiguration) {
        return true;
    }

}
