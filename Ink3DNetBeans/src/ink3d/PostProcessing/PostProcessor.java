/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PostProcessing;

import ink3d.ConfigurationObjects.PrintJobConfiguration;

/**
 *
 * @author Tim
 */
public interface PostProcessor {
    public boolean postprocess(PrintJobConfiguration printJob) throws PostProcessorException;
}
