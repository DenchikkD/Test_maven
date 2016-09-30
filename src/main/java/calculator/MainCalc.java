package calculator;

/**
 * Created by Denni on 9/25/2016.
 */
public class MainCalc {
    private static OperationType operation;
    private static OperationWrapper wrapper;
    private static String result = "0";
    public static void main(String[] args) {
        MyCalc myCalc = new MyCalc();
        myCalc.inChar('0');
        myCalc.inChar('0');
        myCalc.inChar('1');
        myCalc.inChar('0');
        myCalc.inChar('4');
        myCalc.inChar('0');
        myCalc.inChar('-');
        myCalc.inChar('0');
        myCalc.inChar('1');
        myCalc.inChar('1');
        myCalc.inChar('1');
        myCalc.inChar('1');
        myCalc.inChar('0');
        myCalc.inChar('=');

//        switch ('/') {
//            case '/': {
//                if (operation != null)  {
//                    wrapper.setY(Integer.parseInt(result));
//                    result = operation.doOperation(wrapper);
//                }
//                OperationWrapper newWrapper = new OperationWrapper(Integer.parseInt(result));
//                wrapper = newWrapper;
//                operation = OperationType.DIVIDE;
//                break;
//            }
//            case '=': {
//                wrapper.setY(Integer.parseInt(result));
//                result = operation.doOperation(wrapper);
//                //sout
//            }
//        }
//

    }
}
