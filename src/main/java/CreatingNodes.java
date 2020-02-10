import java.util.ArrayList;
import java.util.List;

public class CreatingNodes {

    int identity;
    int parentIdentity;
    String modeLabel;
   static List<Object> nodeList = new ArrayList<Object>();

    public CreatingNodes (int id, int parentID, String label) {
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
        return "{" +
                "id: " + identity +
                ", parentId: " + parentIdentity +
                ", label: '" + modeLabel + '\'' +
                '}';
    }

    public static String addNodes(Object node) {
        if (nodeList.contains(node)) {
            return "Node already exist in the list";
        } else {
            nodeList.add(node);
        }
        return "Node added successfully";
    }
}

