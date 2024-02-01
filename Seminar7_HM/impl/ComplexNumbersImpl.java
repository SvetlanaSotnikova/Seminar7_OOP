package Seminar7_HM.impl;

public class ComplexNumbersImpl implements ComplexNumbers {

    private double realPart;
    private double imaginaryPart;

    public ComplexNumbersImpl(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public double getRealPart() {
        return realPart;
    }

    @Override
    public double getImaginaryPart() {
        return imaginaryPart;
    }
}