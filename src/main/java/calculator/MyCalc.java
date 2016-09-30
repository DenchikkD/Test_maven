package calculator;



/**
 * Created by Denni on 9/24/2016.
 */
public class MyCalc extends AbstractCalc {
    public MyCalc() {

    }

    @Override
    public void inChar(char p) {

        switch (p) {
            default:
                generateValue(p);
                printResult();
                break;
            case '/':
                temp = Integer.parseInt(result);
                printResult();
                result = "";
                operation = '/';
                break;
            case '*':
                temp = Integer.parseInt(result);
                printResult();
                result = "";
                operation = '*';
                break;
            case '-':
                temp = Integer.parseInt(result);
                printResult();
                result = "";
                operation = '-';
                break;
            case '+':
                temp = Integer.parseInt(result);
                printResult();
                result = "";
                operation = '+';
                break;
            case '=':
                doResult();
                printResult();
                break;
        }

    }

    private void generateValue(char p) {
        if (result.length() == 0) {
            result += p;
        } else {
            if (p == '0' && result.equals("0")) {
                result = "0";
            } else if (p == '0' && result.length() >= 1 && !result.equals("0")) {
                result += p;
            } else if (p != '0' && result.length() == 1 && result.equals("0")) {
                result = "" + p;

            } else {
                result += p;
            }
        }
    }


}
