package nodes;

public class Node extends CreatingNode implements Comparable <CreatingNode> {
    public Node(int id, int parentID, String label) {
        super(id, parentID, label);
    }
}
