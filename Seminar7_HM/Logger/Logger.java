package Seminar7_HM.logger;

import java.io.FileWriter;
import java.io.IOException;

public class Logger implements CalculatorLogger {

    private Logger logger;

    public void ComplexCalculator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        if (logger != null) {
            logger.log(message);
        } else {
            // System.out.println("Logger is not initialized!");
        }
    }

    @Override
    public void closeLogger() {
        System.out.println("Closing logger...");
        if (logger != null) {
            logger.closeLogger();
        }
    }

     @Override
    public String toString() {
        return "Logger []";
    }

    public static void writeFile(double num1, double  num2, String nameFile) {
        try (FileWriter fw = new FileWriter(nameFile, true)) {
            fw.write("log: " + num1 + " + " + num2 + "i;");
            fw.append('\n');
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
