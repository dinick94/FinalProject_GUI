
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadTextAsString {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        InputStream inStream = new FileInputStream("../STATIC/ProgramFile.txt");
        BufferedReader inBuffer = new BufferedReader(new InputStreamReader(inStream));
        String line = inBuffer.readLine();
        while (line != null) {
            String tmp[] = line.split(",");
            String name = tmp[0];
            System.out.println(name);
            line = inBuffer.readLine();
        }
        inBuffer.close();
    }
}
