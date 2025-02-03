import java.util.Scanner;

public class Kohli {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the Kohli welcome message
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Kohli\nWhat can I do for you?");
        System.out.println("____________________________________________________________");

        while (true) {
            // Read user input
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                // Exit the chatbot
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } else {
                // Echo user input
                System.out.println("____________________________________________________________");
                System.out.println(userInput);
                System.out.println("____________________________________________________________");
            }
        }

        // Close the scanner
        scanner.close();
    }
}



