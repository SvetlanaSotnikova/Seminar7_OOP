package Seminar7_HM.Calculator;

import Seminar7_HM.Logger.CalculatorLogger;
import Seminar7_HM.impl.ComplexNumbers;

public class ComplexCalculator implements ComplexOperations {

    private CalculatorLogger logger;

    public ComplexCalculator(CalculatorLogger logger) {
        this.logger = logger;
    }

    @Override
    public void sum(ComplexNumbers a, ComplexNumbers b) {
        double realSum = a.getRealPart() + b.getRealPart();
        double imaginarySum = a.getImaginaryPart() + b.getImaginaryPart();

        // logger
        logger.log("Sum: ( " + a.getRealPart() + " + " + a.getImaginaryPart() + "i) + ("
                + b.getRealPart() + " + " + b.getImaginaryPart() + "i) = "
                + realSum + " + " + imaginarySum + "i");

    }

    @Override
    public void multiply(ComplexNumbers a, ComplexNumbers b) {
        double realPart = a.getRealPart() * b.getRealPart()
                - a.getImaginaryPart() * b.getImaginaryPart();
        double imaginaryPart = a.getRealPart() * b.getImaginaryPart()
                + a.getImaginaryPart() * b.getRealPart();
        // logger
        logger.log("Multy: ( " + a.getRealPart() + " + " + a.getImaginaryPart() + "i) * ("
                + b.getRealPart() + " + " + b.getImaginaryPart() + "i) = "
                + realPart + " + " + imaginaryPart + "i");
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
    }

}
