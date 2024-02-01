package Seminar7_HM.logger;

public class Logger implements CalculatorLogger {

    private Logger logger;

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

}
