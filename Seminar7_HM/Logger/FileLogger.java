package Seminar7_HM.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements CalculatorLogger {
    private PrintWriter writer;

    public FileLogger(String filename) throws IOException {
        writer = new PrintWriter(new FileWriter(filename, true));
    }

    @Override
    public void log(String message) {
        writer.println(message);
    }

    public void closeLogger() {
        writer.close();
    }

}
