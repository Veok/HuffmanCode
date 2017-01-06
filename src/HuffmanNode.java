/**
 * @author L on 06.01.2017.
 */
public class HuffmanNode implements Comparable<HuffmanNode> {

    private Integer frequancy;
    private Character value;
    private HuffmanNode left;
    protected HuffmanNode right;
    private String code;


    public HuffmanNode(Integer frequency, Character value) {
        this.frequancy = frequency;
        this.value = value;
    }

    @Override
    public int compareTo(HuffmanNode o) {
        return this.frequancy.compareTo(o.frequancy);
    }

    public Integer getFrequancy() {
        return frequancy;
    }

    public void setFrequancy(Integer frequancy) {
        this.frequancy = frequancy;
    }

    public Character getValue() {
        return value;
    }

    public void setValue(Character value) {
        this.value = value;
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
