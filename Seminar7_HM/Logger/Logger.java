package Seminar7_HM.logger;

public class Logger implements CalculatorLogger {

    @Override
    public void log(String message) {
        System.out.println("Log: " + message);
    }

    @Override
    public void closeLogger() {
       System.out.println("Closing logger...");
    }

    @Override
    public String toString() {
        return "Logger []";
    }

}
