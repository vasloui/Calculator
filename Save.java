import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Save {

    private ArrayList<String> history = new ArrayList<>();

    public void appendAll(ArrayList<String> arr) {
        history.addAll(arr);
    }

    // For getting text output and saving it to an Arraylist.
    public void save(String output) {

        history.add(output);
    }

    public void save(double output) {

        history.add(String.valueOf(output));
    }

    public void saveInp(double input) {

        history.add(" " + String.valueOf(input));
    }

    public void saveInp(String input) {

        history.add(" " + String.valueOf(input));
    }

    public String getHistory() {
        return String.valueOf(history);
    }

    public String formatHistory() {
        String text = "";
        for (String i : history) {
            text += i + '\n';
        }
        return text;
    }

    public void saveHistory() throws IOException {

        Path fileName = Path.of("History.txt");

        Files.writeString(fileName, formatHistory());
    }

}
