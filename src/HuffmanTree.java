import java.util.PriorityQueue;

/**
 * @author L on 07.01.2017.
 */
public class HuffmanTree {

    private HuffmanNode tree;

    public HuffmanTree() {
    }


    public HuffmanNode getTree() {
        return tree;
    }


    public void createTree(PriorityQueue<HuffmanNode> huffmanNodes) {

        if (huffmanNodes.size() == 1) {
            this.tree = huffmanNodes.poll();
        } else {

            HuffmanNode node1 = huffmanNodes.poll();
            HuffmanNode node2 = huffmanNodes.poll();
            HuffmanNode huffmanNode = new HuffmanNode(node1.getFrequency() + node2.getFrequency(), null);
            huffmanNode.setLeft(node1);
            huffmanNode.setRight(node2);
            huffmanNodes.add(huffmanNode);

            createTree(huffmanNodes);
        }
    }
}
