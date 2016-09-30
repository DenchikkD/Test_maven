package calculator;

/**
 * Created by Denni on 9/29/2016.
 */
public enum OperationType {
    PLUS {
        @Override
        public String doOperation(int valueOne, String valueTwo) {
            return "" + (valueOne + toInt(valueTwo));
        }
    },
    MINUS {
        @Override
        public String doOperation(int valueOne, String valueTwo) {
            return "" + (valueOne - toInt(valueTwo));
        }
    },
    DIVIDE {
        @Override
        public String doOperation(int valueOne, String valueTwo) {
            return "" + (valueOne / toInt(valueTwo));
        }
    },
    MULTIPLY {
        @Override
        public String doOperation(int valueOne, String valueTwo) {
            return "" + (valueOne * toInt(valueTwo));
        }
    };

    public abstract String doOperation(int valueOne, String valueTwo);

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }

}
