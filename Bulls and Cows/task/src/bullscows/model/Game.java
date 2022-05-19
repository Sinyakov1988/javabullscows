package bullscows.model;

public class Game {
    public static final int codeSize = 4;
    private char[] code;
    private int count;

    public Game(){
        code = new char[codeSize];
        count = 1;
    }

    public void initGame() {
        code = new char[] {'9', '3', '0', '5'};
        sayCodePrepared();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < codeSize; i++) {
            result += code[i];
        }
        return result;
    }
    private void incCount() {
        count++;
    }
    public void sayTurn() {
        System.out.println("\nTurn " + count + ". Answer:");

    }

    private void sayCodePrepared() {
        System.out.println("The secret code is prepared: ****.");
    }

    public void sayWin() {
        System.out.println("Congrats! The secret code is " + toString() + ".");
    }

    private char[] convert(int answer) {
        char[] res = new char[codeSize];
        for (int i = 0; i < codeSize; i++) {
            int tmp = 1;
            for (int j = 1; j < codeSize - i; j++) {
                tmp *= 10;
            }
            res[i] = (char)(((answer / tmp) %  10 ) + 48);
        }
        return res;
    }

    private int getBulls(int answer) {
        int result = 0;
        char[] buffer = convert(answer);
        for (int i = 0; i < codeSize; i++) {
            if (buffer[i] == code[i]) {
                result++;
            }
        }
        return result;
    }

    private int getCows(int answer) {
        int result = 0;
        char[] buffer = convert(answer);
        for (int i = 0; i < codeSize; i++) {
            for (int j = 0; j < codeSize; j++) {
                if (buffer[i] == code[j] && i != j) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean processAnswer(int answer) {
        int cows = getCows(answer);
        int bulls = getBulls(answer);

        String result = "Grade: ";
        String bullsStr = "";
        String cowsStr = "";

        incCount();

        if (bulls == 0 && cows == 0) {
            result = result + "None";
        } else {
            if (bulls > 0) {
                bullsStr = bulls + (bulls == 1 ? " bull" : " bulls");
            }
            if (cows > 0) {
                cowsStr = cows + (cows == 1 ? " cow" : " cows");
            }
            result = result + bullsStr + (bulls > 0 && cows > 0 ? " and ": "") + cowsStr;
        }

        result += ".";
        System.out.println(result);
        if (bulls == codeSize) {
            sayWin();
            return false;
        }
        return true;
    }
}
