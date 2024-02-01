package Seminar7_HM.Logger;

public class Logger implements CalculatorLogger {

    @Override
    public void log(String message) {
        System.out.println("Log: " + message);
    }

}
