package calculator;

/**
 * Created by Denni on 9/28/2016.
 */
public enum CalcOperations {

    DIVIDE('/'),MULTIPLY('*'),ADDED('+'),SUBTRACTION('-');


    private char operation;

    CalcOperations(char operation) {
        this.operation = operation;
    }

    public char getOperation() {
        return operation;
    }
}
