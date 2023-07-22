import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(500) + 1; 
        Scanner scanner = new Scanner(System.in);int attempts = 0;
        boolean isGuessed = false;
        int maxAttempts = 10;

        System.out.println("Welcome to the Game!");
        System.out.println("I have selected a number between 1 and 500. Can you guess it?");
        System.out.println("You have a maximum of " + maxAttempts + " attempts.");

        while (!isGuessed && attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            int userGuess;
                while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                scanner.next();
            }

            userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number " + randomNumber + " in " + attempts + " attempts.");
                isGuessed = true;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }
        }

        if (!isGuessed) {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
        }

        // Close the scanner
        scanner.close();
    }
}