package Seminar7_HM.util;

public enum Operators {
    PLUS("+"),
    MULTI("*"),
    DIV("/");

    private String operator;

    Operators(String op) {
        this.operator = op;
    }
    public String getOperator() {
        return operator;
    }
}
