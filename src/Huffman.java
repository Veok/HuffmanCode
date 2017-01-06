import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author L on 06.01.2017.
 */
public class Huffman {

    private String code;
    private HuffmanNode tree;
    private HashMap<Character,String> codeMap;


    public Huffman(String code) {

        this.code = code;
        PriorityQueue<HuffmanNode> huffmanNodes = createPriorityQueue(frequencyMap(code));
        createTree(huffmanNodes);
        setCode(tree,"");
        codeMap = new HashMap<>();
        growCodeMap(tree);

    }

    public static void main(String[] args) {
        Huffman huffman = new Huffman("foo");
        System.out.println(huffman.getCodeMap());
        System.out.println(huffman.encode("foo"));
        System.out.println(huffman.decode((huffman.encode("foo"))));
    }

    public String encode(String text){
        String r ="";
        for(int i = 0; i<text.length(); i++){
            if(!codeMap.containsKey(text.charAt(i))){
                return "Error";
            }
            else{
                r += codeMap.get(text.charAt(i));
            }
        }
        return r;
    }
    public HashMap<Character,String> getCodeMap() {
        return this.codeMap;
    }
    public void createTree(PriorityQueue<HuffmanNode> huffmanNodes){

        if(huffmanNodes.size() == 1){
            this.tree = huffmanNodes.poll();
        }else{

            HuffmanNode node1 = huffmanNodes.poll();
            HuffmanNode node2 = huffmanNodes.poll();
            HuffmanNode huffmanNode = new HuffmanNode(node1.getFrequency()+node2.getFrequency(),null);
            huffmanNode.setLeft(node1);
            huffmanNode.setRight(node2);
            huffmanNodes.add(huffmanNode);

            createTree(huffmanNodes);
        }
    }


    public String decode(String encoded){

        HuffmanNode root = tree;
        String r = "";
        for(int i = 0; i<encoded.length(); i++){
            char c = encoded.charAt(i);
            if(c == '1'){
                root = root.getRight();
            }else if(c == '0'){
               root= root.getLeft();
            }

            if(root.getValue()!=null){
                r += root.getValue();
                root = tree;
            }
        }
        return  r;
    }

    public HashMap<Character, Integer> frequencyMap(String source){

        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<source.length();i++){
            Character character = source.charAt(i);
            if(map.containsKey(character)){
                map.put(character,map.get(character)+1);
            }
            else{
                map.put(character,1);
            }
        }
        return map;
    }

    public PriorityQueue<HuffmanNode> createPriorityQueue(HashMap<Character, Integer> frequencyMap){
        PriorityQueue<HuffmanNode> huffmanNodes = new PriorityQueue<>();
        for(Character c: frequencyMap.keySet()){
            huffmanNodes.add(new HuffmanNode(frequencyMap.get(c),c));
        }
        return huffmanNodes;
    }

    public void setCode(HuffmanNode root, String code){
        if(root!=null){
            root.setCode(code);
            setCode(root.getLeft(),code+"0");
            setCode(root.getRight(), code+"1");
        }
    }

    public void growCodeMap(HuffmanNode root){
        if(root!=null){
            if(root.getValue()!=null){
                this.codeMap.put(root.getValue(),root.getCode());
            }
            growCodeMap(root.getLeft());
            growCodeMap(root.getRight());
        }
    }
}
