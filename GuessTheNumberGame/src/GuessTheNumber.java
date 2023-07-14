import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // lets make the user enter the minimum and maximum number para sapg guess nya
        System.out.println("Enter min number: ");
        int min = input.nextInt();

        System.out.println("Enter max number: ");
        int max = input.nextInt();

        // create tayo ng method na mag gegenerate ng random numbers based sa min and max number na ininput ni user.
        int randomNumber = random.nextInt( max - min + 1 )  + min ;
        System.out.println("Try to guess the number!");

        // declare tayo ng int para sa attemps ng user plah hahaha
        int attemps = 0;
        int guess;

        // finaly, method namn para sa pagguess ng user, mag peprint ang program if ang guess ni user ay mababa or mataas, ulit ulit yan hanggangg  sa mahulaan ni user ang tamang number
        // gamit tayo do-while loop
        do {

            //dito magsisimula ang game
            System.out.println("Guess: ");
            guess = input.nextInt();
            attemps++;

            if ( guess < randomNumber ) {
                System.out.println(" too low! ");
            } 

            else if ( guess > randomNumber ) {
                System.out.println(" too high! ");
            }

            else {
                System.out.println(" you guessed it right! " +  guess) ;
            }
        } 

        while ( guess != randomNumber );

        input.close();
        // lets run it
        // nka gawa rin ng easy game, itong program na to ay inspired sa nakita kong python game na ganito rin, para kong nag translate ng language to another language hahahahha
        // anyway the program was a success@!!!!!!!!
        // Coraca
    }    
}
