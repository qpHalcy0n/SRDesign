/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PostProcessing;

import ink3d.ConfigurationObjects.PrintJobConfiguration;


public class Slic3rPostProcessorImpl implements PostProcessor {
    GCodePreparer gCodePreparer;

    public Slic3rPostProcessorImpl() {
        this.gCodePreparer = new Slic3rGCodePreparerImpl();
    }

    @Override
    public boolean postprocess(PrintJobConfiguration printJob) throws PostProcessorException {
        return this.gCodePreparer.prepareGCode(printJob);
    }
    
}
