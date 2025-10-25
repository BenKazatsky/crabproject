import java.util.Random;
import java.util.Scanner;
public class Main {
    public static int rollDice(Random rnd) {
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.printf("Dice Roll: Die 1 = %d, Die 2 = %d, Sum = %d\n", die1, die2, sum);
        return sum;
    }

    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
            System.out.println("Welcome to a new game!");
            int point = 0;
            int initialRoll = rollDice(rnd);
            if (initialRoll == 7 || initialRoll == 11) {
                System.out.println("Natural! You won with an " + initialRoll);
            } else if (initialRoll == 2 || initialRoll == 3 || initialRoll == 12) {
                System.out.println("You crapped with an " + initialRoll + "you lose");
            } else {
                point = initialRoll;
                System.out.println("The point is set to: " + point);
                boolean gameContinues = true;
                while (gameContinues) {
                    System.out.println("Trying for point (" + point + ")");
                    int subsequentRoll = rollDice(rnd);
                    if (subsequentRoll == point) {
                        System.out.println("You made a point with a " + point);
                        gameContinues = false;
                    } else if (subsequentRoll == 7) {
                        System.out.println("Seven out, you lost by rolling a 7");
                        gameContinues = false;
                    }
                }
            }
            System.out.println("Would you like to play again? (y/n)");
            String input = scanner.next();
            playAgain = input.equalsIgnoreCase("y");
        } while (playAgain);
        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
