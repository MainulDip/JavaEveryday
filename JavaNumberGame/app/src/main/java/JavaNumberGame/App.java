/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package JavaNumberGame;

import java.util.Random;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        // System.out.println(new App().getGreeting());

        System.out.println("Hi, Please input your name: ");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();

        System.out.println("Welcome " + name + " Do you want to start the game now? \n Please Select \n \t Yes: Type 1: \n \t No: Type 0:");

        int startGame = scanner.nextInt();

        while(startGame != 1) {
            System.out.println("Do you want to start the game now? \n Please Select \n \t Yes: Type 1: \n \t No: Type 0:");
            startGame = scanner.nextInt();
        }

        System.out.println("You will get 5 chances to guess the right number, if you can, you're the winner :), best of luck :)");

        Random random = new Random();
        int theNumber = random.nextInt(20) + 1;

        int playingState = 0;
        boolean isWinner = false;
        boolean gameOver = false;

        while(!isWinner && !gameOver) {
            playingState++;

            int theGuess = scanner.nextInt();

            if(theNumber == theGuess){
                isWinner = true;
                System.out.println("You're the winner of this game. Enjoy :)");
            } else if (theNumber > theGuess) {
                System.out.println("Hint: You should increase a little");
            } else if (theNumber < theGuess) {
                System.out.println("Hint: You should deScrease a little");
            }

            if(playingState == 5){
                gameOver = true;
                System.out.println("Game Over, You tried 5 times alredy.");
            }
        }



        
    }
}
