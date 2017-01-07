import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author L on 06.01.2017.
 */
public class HuffmanCode {

    private String code;
    private HashMap<Character, String> codeMap;
    private HuffmanTree huffmanTree;
    private PriorityQueue<HuffmanNode> huffmanNodes = new PriorityQueue<>();

    public HuffmanCode(String code) {

        this.huffmanTree = new HuffmanTree();
        this.codeMap = new HashMap<>();
        this.code = code;
        this.huffmanNodes = createPriorityQueue(frequencyMap(code));
        this.huffmanTree.createTree(huffmanNodes);

        generateCode(this.huffmanTree.getTree(), "");

    }


    public String encode() {
        String encodedText = "";
        for (int i = 0; i < code.length(); i++) {
            encodedText += codeMap.get(code.charAt(i));
        }
        return encodedText;
    }

    public String decode(String text) {

        HuffmanNode root = huffmanTree.getTree();
        String decodedText = "";
        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            if (character.equals('1')) {
                root = root.getRight();
            } else if (character.equals('0')) {
                root = root.getLeft();
            }

            if (root.getValue() != null) {
                decodedText += root.getValue();
                root = huffmanTree.getTree();
            }
        }
        return decodedText;
    }

    public HashMap<Character, String> getCodeMap() {
        return this.codeMap;
    }

    public HashMap<Character, Integer> frequencyMap(String text) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character character = text.charAt(i);
            if (map.containsKey(character)) {
                map.put(character, map.get(character) + 1);
            } else {
                map.put(character, 1);
            }
        }
        return map;
    }

    public PriorityQueue<HuffmanNode> createPriorityQueue(HashMap<Character, Integer> frequencyMap) {
        for (Character character : frequencyMap.keySet()) {
            huffmanNodes.add(new HuffmanNode(frequencyMap.get(character), character));
        }
        return huffmanNodes;
    }

    public void generateCode(HuffmanNode root, String code) {
        if (root != null) {
            root.setCode(code);
            if (root.getValue() != null) {
                this.codeMap.put(root.getValue(), root.getCode());
            }
            generateCode(root.getLeft(), code + "0");
            generateCode(root.getRight(), code + "1");
        }
    }
}
