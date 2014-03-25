/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Preprocessing;

import ink3d.ConfigurationObjects.PrintJobConfiguration;

/**
 * Preprocessor Interface
 * @author Tim
 */
public interface Preprocessor {
    public boolean preprocess(PrintJobConfiguration printJobConfiguration);
}
