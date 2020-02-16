package nodes;

import java.util.*;

public class AddingNodes  {
    public  List<CreatingNode> nodeList = new ArrayList< CreatingNode>();
    public  List<CreatingNode> parentNodes = new ArrayList< CreatingNode>();
    public  List<CreatingNode> childNodes = new ArrayList< CreatingNode>();
    HashMap<Integer, CreatingNode> mapping = new HashMap<Integer, CreatingNode>();

    public  String addNodes(Node node) {
        if (nodeList.contains(node)) {
            return "Node already exist in the list";
        } else {
            nodeList.add(node);
        }
        return "Node added successfully";
    }

//    public  List sortingList() {
//        Collections.sort(AddingNodes.nodeList);
////        System.out.println(nodeList);
//        return nodeList;
//    }

    public List getParentNodes() {
        for (int i = 0; i < nodeList.size() ; i++) {
            CreatingNode currentNode = nodeList.get(i);
            if (currentNode.getParentIdentity() == 0) {
                    parentNodes.add(currentNode);
                    mapping.put(currentNode.getIdentity(), currentNode);
            }
        }
        return parentNodes;
    }

    public  List getChildNodes () {
            for (int j = 0; j < nodeList.size() ; j++) {
                if (nodeList.get(j).getParentIdentity() != 0) {
                    childNodes.add(nodeList.get(j));
                }
            }
        return childNodes;
    }

    public  List<CreatingNode> mappingNodes() {
        int count = 0;
        while (count < childNodes.size()) {
                for (int j = 0; j < childNodes.size(); j++) {
                    CreatingNode currentChildNode = childNodes.get(j);
                    // boolean val = parentNode.getIdentity() == currentChildNode.getParentIdentity();
                    CreatingNode parentNode = mapping.get(currentChildNode.getParentIdentity());
                    System.out.println(mapping.get(currentChildNode.getIdentity()));
//                    System.out.println(val + " i: " + i + " => " + parentNode.getIdentity() + " | " + currentChildNode.getParentIdentity());
                    if (parentNode != null) {
                        parentNode.addChild(currentChildNode);
                        mapping.put(currentChildNode.getIdentity(), currentChildNode);
                        count++;
                    } else
                        continue;
                }
            }
        System.out.println("count  " + count);
        return parentNodes;
    }

//    public String printTree(List <CreatingNode> nodes) {
//
//    }
}
