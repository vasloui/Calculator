import java.io.IOException;
import java.util.Objects;

public class Interface {

    Interface() {
    }

    Operations operations = new Operations();
    Temps temps = new Temps();
    Temps tempsYN = new Temps(); // For input at "Do you want to continue [y/N]?".
    Save save = new Save();
    Utilities utilities = new Utilities();


    // For getting, setting and saving input.
    public void printInpSave(String message, String message1) {
        save.save(utilities.print(message));
        temps.setFirst(temps.scanner.nextDouble());
        temps.scanner.nextLine();
        save.saveInp(temps.getFirst());

        save.save(utilities.print(message1));
        temps.setSecond(temps.scanner.nextDouble());
        temps.scanner.nextLine();
        save.saveInp(temps.getSecond());

    }

    public void printInpSave(String message) {
        save.save(utilities.print(message));
        temps.setFirst(temps.scanner.nextDouble());
        temps.scanner.nextLine();
        save.saveInp(temps.getFirst());
    }

    // Gets, validates, sets input and saves it.
    public void interOnStart() {

        onstart:
        while (true) {
            String message = "Enter '1' for '+',\n'2' for '-',\n'3' for '*',\n'4' for '**' (the exponent),\n'5' for 'v-' (the square root)\nor '0' to exit.";
            save.save(utilities.print(message));

            temps.setInput(temps.scanner.nextLine());
            save.saveInp(temps.getInput());

            if (Objects.equals(temps.getInput(), null)) {

            } else if (Objects.equals(temps.getInput(), "")) {

            } else if (Objects.equals(temps.getInput(), "0")) {
                break;
            } else if (Objects.equals(temps.getInput(), "1")) {
                temps.setOperator("1");
                break;
            } else if (Objects.equals(temps.getInput(), "2")) {
                temps.setOperator("2");
                break;
            } else if (Objects.equals(temps.getInput(), "3")) {
                temps.setOperator("3");
                break;
            } else if (Objects.equals(temps.getInput(), "4")) {
                temps.setOperator("4");
                break;
            } else if (Objects.equals(temps.getInput(), "5")) {
                temps.setOperator("5");
                break;
            } else {
                String message1 = "Try again.\nEnter a valid input.";
                save.save(utilities.print(message1));
                continue onstart;
            }
        }

    }


    // Gets user input based on the selected operation.
    public void interOnRepeat() {
        if (!Objects.equals(temps.getOperator(), null)) {

            // After the latests numerical inputs there must be a newline character inserted in the stream by using """temps.scanner.nextLine();""" in order to allow the next String input.
            if (Objects.equals(temps.getOperator(), "1")) {
                String message = "Enter first Addend.";
                String message1 = "Enter second Addend.";

                printInpSave(message, message1);

            } else if (Objects.equals(temps.getOperator(), "2")) {
                String message = "Enter subtrahend.";
                String message1 = "Enter subtractor.";

                printInpSave(message, message1);

            } else if (Objects.equals(temps.getOperator(), "3")) {
                String message = "Enter multiplicand.";
                String message1 = "Enter multiplier.";

                printInpSave(message, message1);

            } else if (Objects.equals(temps.getOperator(), "4")) {
                String message = "Enter base.";
                String message1 = "Enter exponent.";

                printInpSave(message, message1);
            }
            // For the square root only one input is required because the second would be '2' as the index of the root.
            else if (Objects.equals(temps.getOperator(), "5")) {
                String message = "Enter base of square root.";

                printInpSave(message);
            }

        }

    }

    public void interOnEnd() {
        String message = "Program Stopped.";
        System.out.println(message);
        save.save(message);

    }

    // Main Loop.
    public void inter() throws IOException {

        mainLoop:
        do {
            interOnStart();
            if (!(Objects.equals(temps.getInput(), "0"))) {
                interOnRepeat();
                // Passes the 'operator' value across different instances of 'Temps' class.
                operations.temps.setOperator(temps.getOperator());
                // Passes the 'first' value across different instances of 'Temps' class.
                operations.temps.setFirst(temps.getFirst());
                // Passes the 'second' value across different instances of 'Temps' class.
                operations.temps.setSecond(temps.getSecond());

                save.save(utilities.print(operations.calculations()));

            }

            // Exit / Continue?.
            if (!(Objects.equals(temps.getInput(), "0"))) {
                // Continue?
                do {
                    String message = "Do you want to continue [y/N]?";
                    save.save(utilities.print(message));
                    tempsYN.setInput(tempsYN.scanner.nextLine());
                    save.saveInp(tempsYN.getInput());
                    System.out.println("\n");

                } while (!(Objects.equals(tempsYN.getInput(), "Y") || Objects.equals(tempsYN.getInput(), "YES") || Objects.equals(tempsYN.getInput(), "y") || Objects.equals(tempsYN.getInput(), "yes")));
            } else {
                // Exit?
                do {
                    String message = "Are you sure [y/N]?";
                    save.save(utilities.print(message));
                    tempsYN.setInput(tempsYN.scanner.nextLine());
                    save.saveInp(tempsYN.getInput());
                    System.out.println("\n");
                } while (!(Objects.equals(tempsYN.getInput(), "Y") || Objects.equals(tempsYN.getInput(), "YES") || Objects.equals(tempsYN.getInput(), "y") || Objects.equals(tempsYN.getInput(), "yes")));

            }

        } while (!(Objects.equals(temps.getInput(), "0")));
        interOnEnd();
        save.saveHistory();
    }

    public static void main(String[] args) throws IOException {
        Interface interf = new Interface();
        interf.inter();
    }
}
