/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ink3d.Util;

import ink3d.UserInterface.MainMenu.BadFieldException;

/**
 *
 * @author Tim
 */
public class InputValidationUtility {
    public static boolean isStringEmpty(String str) {
        if(str == null) {
            return true;
        }
        String noSpacesStr = str.replaceAll("[ \n\t]", "");

        if("".equals(str)) {
            return true;
        }

        return false;
    }

    public static double parseDouble(String property, String str) throws BadFieldException {
        if(isStringEmpty(str)) {
            String message = property + " must have a value.";
            throw new BadFieldException(message);
        }
        try {
            return Double.parseDouble(str);
        }
        catch(NumberFormatException ex) {
            String message = property + " must be a valid floating point value.";
            throw new BadFieldException(message);
        }
    }

    public static int parseInt(String property, String str) throws BadFieldException {
        if(isStringEmpty(str)) {
            String message = property + " must have a value.";
            throw new BadFieldException(message);
        }
        try {
            return Integer.parseInt(str);
        }
        catch(NumberFormatException ex) {
            String message = property + " must be a valid integer value.";
            throw new BadFieldException(message);
        }
    }

    public static void checkIfInRange(String property, double value, double min, double max) throws BadFieldException {
        if(value < min) {
            String message = property + " must be greater or equal to " + min + ".";
            throw new BadFieldException(message);
        }
        
        if(value > max) {
            String message = property + " must be less than or equal to " + max + ".";
            throw new BadFieldException(message);
        }
    }

    public static void checkIfInRange(String property, int value, int min, int max) throws BadFieldException {
        if(value < min || value > max) {
            String message = property + " must be greater or equal to " + min + ".";
            throw new BadFieldException(message);
        }
        
        if(value > max) {
            String message = property + " must be less than or equal to " + max + ".";
            throw new BadFieldException(message);
        }
    }
}
