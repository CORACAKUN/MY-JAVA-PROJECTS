import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the range: ");
        int range = scanner.nextInt();

        // Printing the sentence based on the range
        for (int i = 1; i <= range; i++) {
            System.out.println(i + " " + sentence);
        }

        // Saving the output to a text file
        saveOutputToFile(sentence, range);

        scanner.close();
    }

    private static void saveOutputToFile(String sentence, int range) {
        String filename = "output.txt";

        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 1; i <= range; i++) {
                writer.write("echo " + i + " " + sentence + System.lineSeparator());
            }

            System.out.println("Output saved to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while saving the output to a file.");
            e.printStackTrace();
        }
    }
}