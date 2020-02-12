package nodesTests;

import nodes.*;
import org.junit.jupiter.api.Test;

import static nodes.CreatingNodes.nodeList;
//import static nodes.CreatingNodes.sortingList;
import static org.junit.jupiter.api.Assertions.*;

public class NodesTest {
    @Test
    public void shouldAddNodesToList() {
        NodeA nodeA = new NodeA(700, 0,"nodeA");
        NodeB nodeB = new NodeB(70, 7000,"nodeB");
        NodeC nodeC = new NodeC(9, 123, "nodes.NodeC");
        NodeD nodeD = new NodeD(12, 7000, "nodes.NodeD");
        NodeE nodeE = new NodeE(25, 7000, "NOdeE");
        NodeF nodeF = new NodeF(3,0, "nodes.NodeF");
        NodeG nodeG = new NodeG(10, 3, "nodes.NodeG");
        CreatingNodes.addNodes(nodeA);
        CreatingNodes.addNodes(nodeB);
        CreatingNodes.addNodes(nodeC);
        CreatingNodes.addNodes(nodeD);
        CreatingNodes.addNodes(nodeE);
        CreatingNodes.addNodes(nodeF);
        CreatingNodes.addNodes(nodeG);
        assertEquals(CreatingNodes.nodeList.toString(), "[{id: 700, parentId: 0, label: 'nodeA'}, {id: 70, parentId: 7000, label: 'nodeB'}, {id: 9, parentId: 123, label: 'nodes.NodeC'}, {id: 12, parentId: 7000, label: 'nodes.NodeD'}, {id: 25, parentId: 7000, label: 'NOdeE'}, {id: 3, parentId: 0, label: 'nodes.NodeF'}, {id: 10, parentId: 3, label: 'nodes.NodeG'}]");
    }

    @Test
    public void shouldGetParentIdForNOde() {
        NodeB nodeB = new NodeB(70, 7000,"nodeB");

        assertEquals(nodeB.getParentIdentity(), 7000);
    }
    @Test
    public void shouldGetIdForNOde() {
        NodeC nodeC = new NodeC(9, 123,"nodeC");

        assertEquals(nodeC.getIdentity(), 9);
    }
    @Test
    public void shouldGetLabelForNOde() {
        NodeD nodeD = new NodeD(12, 7000,"nodeD");

        assertEquals(nodeD.getModeLabel(), "nodeD");
    }
    @Test
    public void shouldSortNods() {

        NodeB nodeB = new NodeB(7, 7000,"nodeB");
        NodeC nodeC = new NodeC(0, 123, "nodes.NodeC");
        NodeA nodeA = new NodeA(7000, 0,"nodeA");
        NodeD nodeD = new NodeD(12, 7000,"nodeD");
        NodeE nodeE = new NodeE(800, 0,"nodeE");
        NodeF nodeF = new NodeF(70, 7000,"nodeF");

        CreatingNodes.addNodes(nodeB);
        CreatingNodes.addNodes(nodeC);
        CreatingNodes.addNodes(nodeD);
        CreatingNodes.addNodes(nodeA);
        CreatingNodes.addNodes(nodeF);
        CreatingNodes.addNodes(nodeE);

        assertEquals(CreatingNodes.sortingList(), "nodeD");
    }
    @Test
    public void shouldGetAllParentNodes() {

        NodeB nodeB = new NodeB(7, 7000,"nodeB");
        NodeC nodeC = new NodeC(0, 123, "nodes.NodeC");
        NodeA nodeA = new NodeA(7000, 0,"nodeA");
        NodeD nodeD = new NodeD(12, 7000,"nodeD");
        NodeE nodeE = new NodeE(800, 0,"nodeE");
        NodeF nodeF = new NodeF(7000, 1,"nodeF");

        CreatingNodes.addNodes(nodeB);
        CreatingNodes.addNodes(nodeC);
        CreatingNodes.addNodes(nodeD);
        CreatingNodes.addNodes(nodeA);
        CreatingNodes.addNodes(nodeE);
        CreatingNodes.addNodes(nodeE);
        CreatingNodes.sortingList();

        assertEquals(CreatingNodes.treeNode(), "nodeD");
    }
}
