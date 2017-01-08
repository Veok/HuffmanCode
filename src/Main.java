import java.io.IOException;
import java.util.Scanner;

/**
 * @author L on 07.01.2017.
 */
public class Main {


    public static void main(String[] args) {

        System.out.println("Podaj źródło tekstu:");
        System.out.println("1. Plik");
        System.out.println("2. Konsola");
        Scanner in = new Scanner(System.in);
        int userChoice = in.nextInt();

        switch (userChoice) {

            case 1: {
                System.out.println("Podaj lokalizacje pliku:");
                Scanner in2 = new Scanner(System.in);
                String sourceOfFile = in2.nextLine();
                try {
                    Huffman huffman = new Huffman(FileHandler.readFile(sourceOfFile));
                    System.out.println("Pracuje...");

                    long startTimeToEncode = System.currentTimeMillis();
                    String compressed = huffman.encode();
                    FileHandler.saveFile(compressed, "EncodedText.txt");
                    long stopTimeOfEncode = System.currentTimeMillis();

                    long elapsedTimeOfEncode = stopTimeOfEncode - startTimeToEncode;

                    System.out.println("Twój tekst został pomyślnie zakodowany i zapisany do pliku.");
                    System.out.println("Czas wykonywania wyniosl: " + elapsedTimeOfEncode + " ms");

                    System.out.println("Czy chcesz odkodować plik?");
                    System.out.println("1. Tak");
                    System.out.println("2. Nie");

                    Scanner in4 = new Scanner(System.in);
                    int choice = in4.nextInt();

                    switch (choice) {

                        case 1: {
                            System.out.println("Dekoduje...");

                            long startTimeToDecode = System.currentTimeMillis();
                            String decompressed = huffman.decode(compressed);
                            FileHandler.saveFile(decompressed, "DecodedText.txt");
                            long stopTimeOfDecode = System.currentTimeMillis();

                            long elapsedTimeOfDecode = stopTimeOfDecode - startTimeToDecode;

                            System.out.println("Plik zostal pomyślnie odkodowany. Resultat został zapisany do pliku.");
                            System.out.println("Czas wykonywania wyniósł: " + elapsedTimeOfDecode + " ms");
                            break;
                        }

                        case 2: {
                            break;
                        }
                    }

                } catch (IOException e) {
                    System.out.println("Zostałą podana nieprawidłowa ścieżka do pliku.");
                }
                break;
            }
            case 2: {

                System.out.println("Podaj tekst:");
                Scanner in3 = new Scanner(System.in);
                String text = in3.nextLine();
                Huffman huffman = new Huffman(text);
                String compressed = huffman.encode();

                System.out.println("Twoj zakodowany tekst:");
                System.out.println(compressed);
                System.out.println("Tekst po dekodowaniu:");
                System.out.println(huffman.decode(compressed));
                break;
            }

        }
    }


}
