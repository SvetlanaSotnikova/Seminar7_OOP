package Seminar7_HM.calculator;

import Seminar7_HM.impl.ComplexNumbers;
import Seminar7_HM.logger.FileLogger;
import Seminar7_HM.logger.Logger;
import Seminar7_HM.util.Operators;

public class ComplexCalculator implements ComplexOperations {

    private Logger logger;

    public ComplexCalculator(Logger logger) {
        this.logger = logger;
    }

    // я добавила эти принты потому что на моем ноуте ничего в консоли не
    // отображается,
    // хотя у ребят, которых я просила проверить все работает, можете сказать
    // почему, я три часа с эти маялась :/
    public void printResult(double realPart, double imaginaryPart, Operators op) {
        System.out.println("Result: " + realPart + op.getOperator() + imaginaryPart + "i");
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
            FileLogger.writeFile(realSum, imaginarySum, " + ", "logHM.txt");
        }

        printResult(realSum, imaginarySum, Operators.PLUS);
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

        FileLogger.writeFile(realPart, imaginaryPart, " * ", "logHM.txt");

        printResult(realPart, imaginaryPart, Operators.MULTI);
    }

    @Override
    public void divide(ComplexNumbers a, ComplexNumbers b) {
        double denominator = b.getRealPart() * b.getRealPart()
                + b.getImaginaryPart() * b.getImaginaryPart();
        double realPart = (a.getRealPart() * b.getRealPart()
                + a.getImaginaryPart() * b.getImaginaryPart()) / denominator;
        double imaginaryPart = (a.getImaginaryPart() * b.getRealPart()
                - a.getRealPart() * b.getImaginaryPart()) / denominator;

        double roundedRealPart = Math.round(realPart * 100.0) / 100.0;
        double roundedImaginaryPart = Math.round(imaginaryPart * 100.0) / 100.0;

        // logger
        logger.log("Div: (" + a.getRealPart() + " + " + a.getImaginaryPart() + "i) / ("
                + b.getRealPart() + " + " + b.getImaginaryPart() + "i) = " + realPart + " + "
                + imaginaryPart + "i");

        FileLogger.writeFile(roundedRealPart, roundedImaginaryPart, " / ", "logHM.txt");

        printResult(roundedRealPart, roundedImaginaryPart, Operators.DIV);
    }

}
