import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {
    public static List<String> readFileAsLines(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader((fileName)))) {
            String line;
            while ((line = input.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lines;
    }

}
