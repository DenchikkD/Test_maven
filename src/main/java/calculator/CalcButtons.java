package calculator;

/**
 * Created by Denni on 9/28/2016.
 */
public enum CalcButtons {
    ZERO('0'), ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'),
    DIVIDE('/'), MULTIPLY('8');

    private char value;

    CalcButtons(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
