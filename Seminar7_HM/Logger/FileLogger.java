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
            writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeLogger();
        }
    }

    @Override
    public void log(String message) {
        writer.println(message);
        // writer.flush();
    }

    public void closeLogger() {
        synchronized (this) {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
