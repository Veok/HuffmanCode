import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * @author L on 08.01.2017.
 */
public class FileHandler {

    public FileHandler() {
    }

    public static String readFile(String filePath) throws IOException {

        StringBuilder fileData = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }

    public static void saveFile(String line, String fileName) throws IOException {

        List<String> lines = Collections.singletonList(line);
        Path file = Paths.get(fileName);
        Files.write(file, lines, Charset.forName("UTF-8"));

    }

}
