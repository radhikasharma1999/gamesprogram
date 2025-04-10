package org.example;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println(" Welcome to the Number Guessing Game!");
        System.out.println("---------------------------------------------------");
        System.out.println("Rules:");
        System.out.println("1. I have selected a number between 1 and 100.");
        System.out.println("2. You have to guess the number based on difficulty level.");
        System.out.println("3. After each guess, I will tell you if the number is higher or lower.");
        System.out.println("4. Game ends when you guess correctly or run out of chances.");
        System.out.println("---------------------------------------------------");

        int target = rand.nextInt(100) + 1;
        int attempts = 0;
        int maxChances = 0;

        while (true) {
            System.out.print("Select difficulty (easy / medium / hard): ");
            String difficulty = scanner.nextLine().toLowerCase();

            if (difficulty.equals("easy")) {
                maxChances = 10;
                break;
            } else if (difficulty.equals("medium")) {
                maxChances = 7;
                break;
            } else if (difficulty.equals("hard")) {
                maxChances = 5;
                break;
            } else {
                System.out.println("----Invalid input. Please enter easy, medium, or hard.");
            }
        }


        boolean guessedCorrectly = false;

        while (attempts < maxChances) {
            System.out.printf("Attempt %d of %d - Enter your guess: ", attempts + 1, maxChances);
            String input = scanner.nextLine();

            int guess;

            try {
                guess = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("----Please enter a valid number between 1 and 100.");
                continue;
            }

            if (guess < 1 || guess > 100) {
                System.out.println("----Guess must be between 1 and 100.");
                continue;
            }

            attempts++;

            if (guess == target) {
                System.out.printf("Congratulations! You guessed the number in %d attempt(s)!\n", attempts);
                guessedCorrectly = true;
                break;
            } else if (guess < target) {
                System.out.println("The number is higher than your guess.");
            } else {
                System.out.println("The number is lower than your guess.");
            }
        }

        if (!guessedCorrectly) {
            System.out.printf("You've run out of chances. The correct number was %d.\n", target);
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
