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
//                    System.out.println(mapping.get(currentChildNode.getIdentity()));
//                    System.out.println(val + " i: " + i + " => " + parentNode.getIdentity() + " | " + currentChildNode.getParentIdentity());
                    if (parentNode != null) {
                        parentNode.addChild(currentChildNode);
                        mapping.put(currentChildNode.getIdentity(), currentChildNode);
                        count++;
                    } else
                        continue;
                }
            }
//        System.out.println("count  " + count);
        return parentNodes;
    }

    public String printTree(List <CreatingNode> nodes) {
        for (int i = 0; i <parentNodes.size() ; i++) {
//            int parentId = parentNodes.get(i).getParentIdentity();
            int id = parentNodes.get(i).getIdentity();
            String label = parentNodes.get(i).getModeLabel();
            System.out.println("label " + label + " | "  );
            for (int j = 0; j <nodes.size() ; j++) {
                CreatingNode kid = nodes.get(j);
                System.out.println(kid.getModeLabel() + " | " + kid.getParentIdentity());
                if (kid.getParentIdentity() == id) {
                    System.out.println("phakathi ");
                    System.out.println(kid.getModeLabel());
                }
                for (int k = 0; k < nodes.size(); k++) {
                    CreatingNode grandChild = nodes.get(j);
                    if (grandChild.getParentIdentity() == kid.getIdentity()) {
                        System.out.println("phakathi ");
                        System.out.println(grandChild.getModeLabel() + " | " + grandChild.getParentIdentity());
                    }
                }
            }
        }
        return nodes.toString();
    }

}
