package Seminar7_HM.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements CalculatorLogger {
    private PrintWriter writer;

    public FileLogger(String filename) {
        try {
            this.writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            e.printStackTrace();
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

}
