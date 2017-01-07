import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author L on 07.01.2017.
 */
public class Main {


    private static String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
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

    public static void main(String[] args) {


        System.out.println("Witaj!");
        System.out.println("Podaj źródło tekstu:");
        System.out.println("1. Plik");
        System.out.println("2. Konsola");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();

        switch (userChoice) {

            case 1: {
                System.out.println("Podaj lokalizacje pliku:");
                Scanner in3 = new Scanner(System.in);
                String lc = in3.nextLine();
                try {
                    HuffmanCode huffmanCode = new HuffmanCode(readFileAsString(lc));
                    System.out.println("Twoj zakodowany tekst:");
                    System.out.println(huffmanCode.getCodeMap());
                    System.out.println(huffmanCode.encode());
                    System.out.println("Tekst po dekodowaniu:");
                    List<String> lines2 = Arrays.asList(huffmanCode.encode());
                    Path file2 = Paths.get("encoded2.txt");
                    Files.write(file2, lines2, Charset.forName("UTF-8"));
                    System.out.println(huffmanCode.decode(readFileAsString(file2.toString())));
                    System.out.println("Wyniki zostana zapisane do pliku");
                    List<String> lines = Arrays.asList(huffmanCode.getCodeMap().toString(), huffmanCode.encode());
                    Path file = Paths.get("encoded.txt");
                    Files.write(file, lines, Charset.forName("UTF-8"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {

                Scanner in2 = new Scanner(System.in);
                String text = in2.nextLine();
                HuffmanCode huffmanCode = new HuffmanCode(text);
                System.out.println("Twoj zakodowany tekst:");
                System.out.println(huffmanCode.getCodeMap());
                System.out.println(huffmanCode.encode());
                System.out.println("Tekst po dekodowaniu:");
                System.out.println(huffmanCode.decode(huffmanCode.encode()));

                break;
            }

        }


        // HuffmanCode huffmanCode = new HuffmanCode("Ala ma kota matematyka");
        // System.out.println(huffmanCode.getCodeMap());
        //  System.out.println(huffmanCode.encode("Ala ma kota matematyka"));
        // System.out.println(huffmanCode.decode((huffmanCode.encode("Ala ma kota matematyka"))));
    }


}
