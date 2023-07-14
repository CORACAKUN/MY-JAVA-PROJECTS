import java.util.Scanner;
import java.util.Random;


public class GuessTheNumber {
    public static void main(String[] args) {

        Scanner  input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter min number range: ");
        int min = input.nextInt();

        System.out.println("Enter max number range: ");
        int max = input.nextInt();

        // method to generate random numbers between the user entered range value
        int randomNumber = random.nextInt( max - min + 1 ) + min;

        System.out.println("Try to guess the number");

        // user attemps (to guess)
        int attempts = 0;
        int guess;

        // i think we can you do-while loop para mka guess ng marami between sa na enter nya na min at max  untill he succeed to guess the right number, let's do it
        do {
            
            System.out.println("Guess: ");
            guess = input.nextInt();
            attempts++;

            // we will use if else if and else pra hbang nag nageguess si user, sasabjin ng system kung mababa or mataas ang guess nya unti nahulaan nya ang tamang numbers
            if ( guess < randomNumber ) {
                System.out.println("Too low!");
            } else if ( guess < randomNumber ) {
                System.out.println("too high!");
            } else {
                System.out.println("You guess it " + guess );
            }

        } while ( guess != randomNumber );

        input.close();
    }
}