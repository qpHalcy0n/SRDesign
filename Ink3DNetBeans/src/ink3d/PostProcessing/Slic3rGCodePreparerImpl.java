/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.PostProcessing;

import ink3d.ConfigurationObjects.ExtruderConfiguration;
import ink3d.ConfigurationObjects.PrintJobConfiguration;
import ink3d.ConfigurationObjects.SubsetConfiguration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tim
 */
public class Slic3rGCodePreparerImpl implements GCodePreparer {
    private static final String BASE_DIR = new File("").getAbsolutePath();
    public static String GCODE_DIR = BASE_DIR + File.separator + "gcode";
    public static final int FILE_MARK_LIMIT = 500;

    private PrintJobConfiguration printJob;
    private int currentTool;

    @Override
    public boolean prepareGCode(PrintJobConfiguration printJob) throws PostProcessorException {
        this.printJob = printJob;
        this.currentTool = -1;
        return postProcessGCodes();
    }

    private boolean postProcessGCodes() throws PostProcessorException {
        String finalizedGCodeFilename = GCODE_DIR + File.separator + printJob.getName();
        File finalizedGCode = new File(finalizedGCodeFilename);
        // Create directory for finalize gcode file if it does not exist.
        if(!finalizedGCode.exists()) {
            File finalizedGCodeDir = finalizedGCode.getParentFile();
            if(!finalizedGCodeDir.exists()) {
                if(!finalizedGCodeDir.mkdirs()) {
                    throw new PostProcessorException("Could not create directory to store finalized G-Code.");
                }
            }
        }

        BufferedWriter outFile = null;
        try {
            finalizedGCode.createNewFile();

            // Open the file to write to
            outFile = new BufferedWriter(new FileWriter(finalizedGCode));
        } 
        catch (IOException ex) {
            Logger.getLogger(Slic3rGCodePreparerImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new PostProcessorException("Could not create finalized G-Code file.");
        }

        // Write printer start gcode.
        writePrinterStartGCode(outFile);

        // Write each subset's gcode to the finalized file.
        // This includes custom G-Code for tool changes that happen within
        // each subset.
        List<SubsetConfiguration> subsets = printJob.getSubsetConfigurationList();
        for(SubsetConfiguration subset : subsets) {
            writeSubsetGCode(outFile, subset);
        }

        // Write printer end gcode.
        writePrinterEndGCode(outFile);

        // Set the reference for the finalized GCode in the Print Job.
        printJob.setFinalizedGCode(finalizedGCode);

        return true;

    }

    private boolean writePrinterStartGCode(BufferedWriter outputFile) {
        String startGCode = printJob.getPrinterConfiguration().getStartGCode();
        try {
            outputFile.append(startGCode);
            outputFile.append("\n");
        } catch (IOException ex) {
            Logger.getLogger(Slic3rGCodePreparerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private boolean writePrinterEndGCode(BufferedWriter outputFile) {
        String endGCode = printJob.getPrinterConfiguration().getEndGCode();
        try {
            outputFile.append(endGCode);
            outputFile.append("\n");
            outputFile.flush();
        } catch (IOException ex) {
            Logger.getLogger(Slic3rGCodePreparerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private boolean writeSubsetGCode(BufferedWriter outputFile, SubsetConfiguration subset) {
        File subsetGCodeFile = subset.getgCodeFile();
        Pattern toolSelectionPattern = Pattern.compile("^(T[0-9])");
        try {
            BufferedReader subsetGCode = new BufferedReader(new FileReader(subsetGCodeFile));
            scanForNextToolSelection(subsetGCode);
            String line = "";
            while((line = subsetGCode.readLine()) != null) {
                System.out.println("line = " + line);
                Matcher matcher = toolSelectionPattern.matcher(line);
                if(matcher.find()) {
                    writeToolChangeEndGCode(outputFile, this.currentTool);
                    String tCode = matcher.group();
                    this.currentTool = Integer.parseInt(tCode.substring(1));
                    writeToolChangeStartGCode(outputFile, this.currentTool);
                }
                outputFile.append(line);
                outputFile.append("\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Slic3rGCodePreparerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Slic3rGCodePreparerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    private boolean scanForNextToolSelection(BufferedReader gCodeFile) throws IOException {
        String line = "";
        Pattern toolSelectionPattern = Pattern.compile("^(T[0-9])");
        gCodeFile.mark(FILE_MARK_LIMIT);
        while((line = gCodeFile.readLine()) != null) {
            Matcher matcher = toolSelectionPattern.matcher(line);
            if(matcher.find()) {
                gCodeFile.reset();
                return true;
            }
            // mark this position so we can reset to it when we find a tool selection
            gCodeFile.mark(FILE_MARK_LIMIT);
        }
        return false;
    }

    private void writeToolChangeEndGCode(BufferedWriter outputFile, int extruder) throws IOException {
        List<ExtruderConfiguration> extruderConfigList = 
                printJob.getPrinterConfiguration().getExtruderList();

        // Only write tool change end g code if the given extruder/tool
        // is specified.  Otherwise do nothing.
        if(extruder >= 0 && extruder < extruderConfigList.size()) {
            ExtruderConfiguration extruderConfig = extruderConfigList.get(extruder);

            String toolChangeEndGCode = extruderConfig.getEndGCode();
            outputFile.append(toolChangeEndGCode);
            outputFile.append("\n");
        }

    }

    private boolean writeToolChangeStartGCode(BufferedWriter outputFile, int extruder) throws IOException {
        ExtruderConfiguration extruderConfig = printJob.getPrinterConfiguration()
                                                 .getExtruderList().get(extruder);
        String toolChangeStartGCode = extruderConfig.getStartGCode();
        outputFile.append(toolChangeStartGCode);
        outputFile.append("\n");
        return true;
    }
 
}