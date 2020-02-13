package nodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddingNodes  {
    public static List<CreatingNodes> nodeList = new ArrayList< CreatingNodes>();
    public static List<CreatingNodes> parentNodes = new ArrayList< CreatingNodes>();
    public static List<CreatingNodes> childNodes = new ArrayList< CreatingNodes>();

    public static String addNodes(Node node) {
        if (nodeList.contains(node)) {
            return "Node already exist in the list";
        } else {
            nodeList.add(node);
        }
        return "Node added successfully";
    }

    public static List sortingList() {
        Collections.sort(AddingNodes.nodeList);
        System.out.println(nodeList);
        return nodeList;
    }

    public static List getParentNodes() {
        for (int i = 0; i < nodeList.size() ; i++) {
            for (int j = 1; j < nodeList.size() ; j++) {
                if (nodeList.get(i).getIdentity() == nodeList.get(j).parentIdentity) {
                    if (parentNodes.contains(nodeList.get(i))) {
                        continue;
                    }
                    System.out.println(nodeList.get(i));
                    parentNodes.add(nodeList.get(i));
                    System.out.println( "nantsi" + nodeList.toString());
                }
            }
        }
        return parentNodes;
    }

    public static List getChildNodes () {
        for (int i = 0; i <nodeList.size() ; i++) {
            for (int j = 1; j < nodeList.size() ; j++) {
                if (nodeList.get(i).getIdentity() == nodeList.get(j).getParentIdentity()) {
                    if (childNodes.contains(nodeList.get(j))) {
                        continue;
                    }
                    childNodes.add(nodeList.get(j));
                }
            }
        }
        System.out.println(childNodes);
        return childNodes;
    }


}
