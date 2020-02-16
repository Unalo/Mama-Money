package nodes;

import java.util.ArrayList;
import java.util.List;

public class CreatingNode implements Comparable <CreatingNode>{

    private int identity;
    private int parentIdentity;
    private String modeLabel;
    List<CreatingNode> childNodes = new ArrayList< CreatingNode>();

    public CreatingNode (int id, int parentID, String label) {
        identity = id;
        parentIdentity =parentID;
        modeLabel = label;
    }

    public int getParentIdentity() {
        return this.parentIdentity;
    }

    public int getIdentity () {
        return this.identity;
    }

    public String getModeLabel () {
        return this.modeLabel;
    }


    @Override
    public String toString() {
        return "node { " +
                "identity: " + identity +
                ", parentIdentity " + parentIdentity +
                ", modeLabel '" + modeLabel + '\'' +
                ", childNodes " + childNodes +
                " }";
    }

    @Override
    public int compareTo(CreatingNode o) {
        if (this.getParentIdentity() == o.getIdentity()) {
            System.out.println();
            return o.getIdentity() - this.getParentIdentity();
        }
      return this.modeLabel.compareTo(o.getModeLabel());
    }

    public void addChild(CreatingNode currentChildNode) {
        childNodes.add(currentChildNode);
    }
}

