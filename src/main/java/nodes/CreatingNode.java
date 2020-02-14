package nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreatingNode implements Comparable <CreatingNode>{

    private int identity;
    private int parentIdentity;
    private String modeLabel;
//    List<CreatingNodes> nodeList = new ArrayList< CreatingNodes>();
//    List<CreatingNodes> parentNodes = new ArrayList< CreatingNodes>();
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

//    @Override
//    public String toString() {
//        return "{" +
//                "id: " + identity +
//                ", parentId: " + parentIdentity +
//                ", label: '" + modeLabel + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "CreatingNodes{" +
                "identity=" + identity +
                ", parentIdentity=" + parentIdentity +
                ", modeLabel='" + modeLabel + '\'' +
//                ", nodeList=" + nodeList +
//                ", parentNodes=" + parentNodes +
                ", childNodes=" + childNodes +
                '}';
    }

//    public static String addNodes(CreatingNodes node) {
//        if (nodeList.contains(node)) {
//            return "Node already exist in the list";
//        } else {
//            nodeList.add(node);
//        }
//        return "Node added successfully";
//    }

//    public static List sortingList() {
//        Collections.sort(CreatingNodes.nodeList);
//        System.out.println(nodeList);
//        return nodeList;
//    }

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

//    public static List treeNode() {
//        for (int i = 0; i < nodeList.size() ; i++) {
//            for (int j = 1; j < nodeList.size() ; j++) {
//                if (nodeList.get(i).getIdentity() == nodeList.get(j).parentIdentity) {
//                    if (parentNodes.contains(nodeList.get(i))) {
//                        continue;
//                    }
//                    System.out.println(nodeList.get(i));
//                    parentNodes.add(nodeList.get(i));
//                }
//            }
//        }
//        return parentNodes;
//    }
}

