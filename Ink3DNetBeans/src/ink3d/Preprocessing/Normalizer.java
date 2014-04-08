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
public interface Normalizer {
    public boolean normalize(PrintJobConfiguration printJobConfiguration) throws PreprocessorException;
}
