/**
 * @author L on 08.01.2017.
 */
public class Huffman {

    private String text;
    private HuffmanCode huffmanCode;

    public Huffman(String text) {
        this.text = text;
        this.huffmanCode = new HuffmanCode(text);

    }

    public String encode() {
        String encodedText = "";
        for (int i = 0; i < huffmanCode.getCode().length(); i++) {
            encodedText += huffmanCode.getCodeMap().get(huffmanCode.getCode().charAt(i));
        }
        return encodedText;
    }

    public String decode(String compressedText) {

        HuffmanNode root = huffmanCode.getHuffmanTree().getTree();
        String decodedText = "";
        for (int i = 0; i < compressedText.length(); i++) {
            Character character = compressedText.charAt(i);
            if (character.equals('1')) {
                root = root.getRight();
            } else if (character.equals('0')) {
                root = root.getLeft();
            }

            if (root.getValue() != null) {
                decodedText += root.getValue();
                root = huffmanCode.getHuffmanTree().getTree();
            }
        }
        return decodedText;
    }
}
