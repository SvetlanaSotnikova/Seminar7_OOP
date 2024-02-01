package Seminar7_HM.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements CalculatorLogger {
    private PrintWriter writer;

    public FileLogger(PrintWriter writer) {
        this.writer = writer;
    }


    public FileLogger(String filename) {
        try {
            this.writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeLogger();
        }
    }

    @Override
    public void log(String message) {
        if (writer != null) {
            writer.println(message);
        } else {
            System.err.println("Logger is not initialized.");
        }
    }

    public void closeLogger() {
        if (writer != null) {
            writer.close();
        }
    }

    public static void writeFile(double num1, double  num2, String operation, String nameFile) {
        try (FileWriter fw = new FileWriter(nameFile, true)) {
            fw.write("log: " + num1 + operation + num2 + "i;");
            fw.append('\n');
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
