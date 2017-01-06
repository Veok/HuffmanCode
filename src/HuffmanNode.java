/**
 * @author L on 06.01.2017.
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    private Integer frequency;
    private Character value;
    private HuffmanNode left;
    private HuffmanNode right;
    private String code;


    public HuffmanNode(Integer frequency, Character value) {
        this.frequency = frequency;
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.frequency.compareTo(o.frequency);
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Character getValue() {
        return value;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
