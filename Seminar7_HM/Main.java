package Seminar7_HM;

// import java.io.IOException;
// import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import Seminar7_HM.calculator.ComplexCalculator;
import Seminar7_HM.impl.ComplexNumbers;
import Seminar7_HM.impl.ComplexNumbersImpl;
import Seminar7_HM.logger.CalculatorLogger;
import Seminar7_HM.logger.FileLogger;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        ComplexCalculator calculator = createCalculator();
        // if (calculator != null) {
        Map<Integer, Runnable> menuMap = createMenu(view, calculator);
        boolean exit = false;
        while (!exit) {
            view.menu();
            int choice = view.getUserChoice();

            Runnable action = menuMap.getOrDefault(choice,
                    () -> view.displayMessage("something wrong :( please, try again!"));
            action.run();

            if (choice == 0) {
                exit = true;
            }
        }

        view.closeScan();
    }

    private static ComplexCalculator createCalculator() {
        CalculatorLogger logger = null;
        logger = new FileLogger("logHM.txt");
        return new ComplexCalculator(logger);
    }

    private static void perfOperation(View view, ComplexCalculator calculator,
            BiConsumer<ComplexNumbers, ComplexNumbers> operation) {
        // первое число
        double realPart1 = view.getRealPart();
        double imaginaryPart1 = view.getImaginaryPart();

        // второе число
        double realPart2 = view.getRealPart();
        double imaginaryPart2 = view.getImaginaryPart();

        ComplexNumbersImpl num1 = new ComplexNumbersImpl(realPart1, imaginaryPart1);
        ComplexNumbersImpl num2 = new ComplexNumbersImpl(realPart2, imaginaryPart2);

        operation.accept(num1, num2);
    }

    private static Map<Integer, Runnable> createMenu(View view, ComplexCalculator calculator) {
        Map<Integer, Runnable> menuMap = new HashMap<>();
        menuMap.put(1, () -> perfOperation(view, calculator, calculator::sum));
        menuMap.put(2, () -> perfOperation(view, calculator, calculator::multiply));
        menuMap.put(3, () -> perfOperation(view, calculator, calculator::divide));
        menuMap.put(0, () -> view.displayMessage("Existing ..."));

        return menuMap;
    }
}
