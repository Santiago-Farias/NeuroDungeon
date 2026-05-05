package utils;

import java.util.Scanner;


public class Validator {
    public static int requestValidIndex(Scanner scanner, int inputMin, int inputMax, String inputText) { // if the inputMin is 0, and user enter text, this thing will show a error with 0 too
        String inputStringTemp;
        int stringConveted = 0;
        boolean stringConvertedFlag;
        
        do {
            stringConvertedFlag = true;
            System.out.print(inputText);
            inputStringTemp = scanner.nextLine();
        try {
            stringConveted = Integer.parseInt(inputStringTemp);
        } catch (NumberFormatException e) {
            System.out.println("Error converting '" + inputStringTemp + "' to an integer: " + e);
            stringConvertedFlag = false;
        } 
        
        if ((stringConveted < inputMin || stringConveted > inputMax)) {
            System.out.println("The '" + stringConveted + "' value is out of valid range! (Valid range: " + inputMin + " -> " + inputMax + ")");
            stringConvertedFlag = false;
        }
        } while (stringConvertedFlag == false);
       
        return stringConveted;
    }
}
