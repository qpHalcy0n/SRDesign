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

    private Normalizer normalizer;

    @Override
    public boolean preprocess(PrintJobConfiguration printJobConfiguration) throws PreprocessorException {
        normalizer = new Slic3rNormalizerImpl();
        return normalizer.normalize(printJobConfiguration);
    }
}
