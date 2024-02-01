package Seminar7_HM.logger;

public class Logger implements CalculatorLogger {

    private CalculatorLogger logger;

    public Logger(CalculatorLogger logger) {
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        if (logger != null) {
            logger.log(message);
        } else {
            System.out.println("Logger is not initialized!");
        }
    }

    @Override
    public void closeLogger() {
        System.out.println("Closing logger...");
        if (logger != null) {
            logger.closeLogger();
        }
    }
}
