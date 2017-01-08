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

    public String getCode() {
        return code;
    }

    public HuffmanTree getHuffmanTree() {
        return huffmanTree;
    }

    public HashMap<Character, String> getCodeMap() {
        return this.codeMap;
    }

    private HashMap<Character, Integer> frequencyMap(String text) {

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

    private PriorityQueue<HuffmanNode> createPriorityQueue(HashMap<Character, Integer> frequencyMap) {
        for (Character character : frequencyMap.keySet()) {
            huffmanNodes.add(new HuffmanNode(frequencyMap.get(character), character));
        }
        return huffmanNodes;
    }

    private void generateCode(HuffmanNode root, String code) {
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
