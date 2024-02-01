package Seminar7_HM.calculator;

import Seminar7_HM.impl.ComplexNumbers;
// import Seminar7_HM.logger.CalculatorLogger;
import Seminar7_HM.logger.Logger;

public class ComplexCalculator implements ComplexOperations {

    private Logger logger;

    public ComplexCalculator(Logger logger) {
        this.logger = logger;
    }

    public void printResultSum(double realPart, double imaginaryPart) {
        System.out.println("Result: " + realPart + " + " + imaginaryPart + "i");
    }

    public void printResultMultyply(double realPart, double imaginaryPart) {
        System.out.println("Result: " + realPart + " * " + imaginaryPart + "i");
    }

    public void printResultDiv(double realPart, double imaginaryPart) {
        System.out.println("Result: " + realPart + " / " + imaginaryPart + "i");
    }

    @Override
    public void sum(ComplexNumbers a, ComplexNumbers b) {
        double realSum = a.getRealPart() + b.getRealPart();
        double imaginarySum = a.getImaginaryPart() + b.getImaginaryPart();

        // logger
        if (logger != null) {
            logger.log("Sum: ( " + a.getRealPart() + " + " + a.getImaginaryPart() + "i) + ("
                    + b.getRealPart() + " + " + b.getImaginaryPart() + "i) = "
                    + realSum + " + " + imaginarySum + "i");
        } 

        Logger.writeFile(realSum, imaginarySum, "logHM.txt");

        printResultSum(realSum, imaginarySum);
    }

    @Override
    public void multiply(ComplexNumbers a, ComplexNumbers b) {
        double realPart = a.getRealPart() * b.getRealPart()
                - a.getImaginaryPart() * b.getImaginaryPart();
        double imaginaryPart = a.getRealPart() * b.getImaginaryPart()
                + a.getImaginaryPart() * b.getRealPart();
        // logger
        logger.log("Multyply: ( " + a.getRealPart() + " + " + a.getImaginaryPart() + "i) * ("
                + b.getRealPart() + " + " + b.getImaginaryPart() + "i) = "
                + realPart + " + " + imaginaryPart + "i");

        Logger.writeFile(realPart, imaginaryPart, "logHM.txt");

        printResultMultyply(realPart, imaginaryPart);
    }

    @Override
    public void divide(ComplexNumbers a, ComplexNumbers b) {
        double denominator = b.getRealPart() * b.getRealPart()
                + b.getImaginaryPart() * b.getImaginaryPart();
        double realPart = (a.getRealPart() * b.getRealPart()
                + a.getImaginaryPart() * b.getImaginaryPart()) / denominator;
        double imaginaryPart = (a.getImaginaryPart() * b.getRealPart()
                - a.getRealPart() * b.getImaginaryPart()) / denominator;
        // logger
        logger.log("Div: (" + a.getRealPart() + " + " + a.getImaginaryPart() + "i) / ("
                + b.getRealPart() + " + " + b.getImaginaryPart() + "i) = " + realPart + " + "
                + imaginaryPart + "i");

        Logger.writeFile(realPart, imaginaryPart, "logHM.txt");

        printResultDiv(realPart, imaginaryPart);
    }

}
