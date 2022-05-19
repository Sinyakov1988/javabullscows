package bullscows;

import bullscows.model.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        game.initGame();

        game.sayTurn();
        System.out.println("1234");
        game.processAnswer(1234);

        game.sayTurn();
        System.out.println("5678");
        game.processAnswer(5678);

        game.sayTurn();
        System.out.println("9305");
        game.processAnswer(9305);
    }
}
