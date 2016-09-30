package calculator;

/**
 * Created by Denni on 9/24/2016.
 */
public abstract class AbstractCalc implements Calculator {
    protected String result = "";
    protected int temp;
    protected char operation;


    @Override
    public void printResult() {
        System.out.println("Result = " + result);
    }

    public String getResult() {
        return result;
    }

    public void doResult() {
        switch (operation) {
            case '*':

                result = OperationType.MULTIPLY.doOperation(temp, result);
                break;
            case '/':
                if (result.equals("0")) {
                    result = ByZero;
                } else {
                    result = OperationType.DIVIDE.doOperation(temp, result);
                }
                break;
            case '+':
                result = OperationType.PLUS.doOperation(temp, result);
                break;
            case '-':
                result = OperationType.MINUS.doOperation(temp, result);
                break;
        }
    }
}
