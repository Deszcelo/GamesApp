import java.util.Scanner;

public class Main {
    static final Scanner scan = new Scanner(System.in);

    private interface Game {
        void startGame();
    }

    class HiLo implements Game {
        @Override
        public void startGame() {
            String playAgain = "";
            do {
                int numberOfTries = 0;
                // Create a random number for the user to guess
                int theNumber = (int) (Math.random() * 200 - 100);
                // System.out.println( theNumber );
                int guess = 0;
                while (guess != theNumber) {
                    System.out.println("Guess a number between -100 and 100:");
                    guess = scan.nextInt();
                    numberOfTries++;
                    if (guess < theNumber)
                        System.out.println(guess + " is too low. Try again.");
                    else if (guess > theNumber)
                        System.out.println(guess + " is too high. Try again.");
                    else
                        System.out.println(guess + " is correct. You win!\n" +
                                "It only took you " + numberOfTries + " tries! Good work!");
                }   // End of while loop for guessing
                System.out.println("Would you like to play again (y/n)?");
                playAgain = scan.next();
            } while (playAgain.equalsIgnoreCase("y"));
            System.out.println("Thank you for playing! Goodbye.");
        }
    }

    public static void main(String[] args) {
        new Main().new HiLo().startGame();
        scan.close();
    }
}
