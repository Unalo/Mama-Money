package nodesTests;

import nodes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static nodes.CreatingNodes.*;
import static org.junit.jupiter.api.Assertions.*;

public class NodesTest {

    @BeforeEach
    public void clearMap() {
        nodeList.clear();
        childNodes.clear();
        parentNodes.clear();
    }

    @Test
    public void shouldAddNodesToList() {
        Node nodeA = new Node(700, 0,"nodeA");
        Node nodeB = new Node(70, 7000,"nodeB");
        Node nodeC = new Node(9, 123, "nodes.NodeC");
        Node nodeD = new Node(12, 7000, "nodes.NodeD");
        Node nodeE = new Node(25, 7000, "NOdeE");
        Node nodeF = new Node(3,0, "nodes.NodeF");
        Node nodeG = new Node(10, 3, "nodes.NodeG");

        AddingNodes.addNodes(nodeA);
        AddingNodes.addNodes(nodeB);
        AddingNodes.addNodes(nodeC);
        AddingNodes.addNodes(nodeD);
        AddingNodes.addNodes(nodeE);
        AddingNodes.addNodes(nodeF);
        AddingNodes.addNodes(nodeG);
        assertEquals(AddingNodes.nodeList.toString(), "[{id: 700, parentId: 0, label: 'nodeA'}, {id: 70, parentId: 7000, label: 'nodeB'}, {id: 9, parentId: 123, label: 'nodes.NodeC'}, {id: 12, parentId: 7000, label: 'nodes.NodeD'}, {id: 25, parentId: 7000, label: 'NOdeE'}, {id: 3, parentId: 0, label: 'nodes.NodeF'}, {id: 10, parentId: 3, label: 'nodes.NodeG'}]");
    }

    @Test
    public void shouldGetParentIdForNOde() {
        Node nodeB = new Node(70, 7000,"nodeB");

        assertEquals(nodeB.getParentIdentity(), 7000);
    }

    @Test
    public void shouldGetIdForNOde() {
        Node nodeC = new Node(9, 123,"nodeC");

        assertEquals(nodeC.getIdentity(), 9);
    }

    @Test
    public void shouldGetLabelForNOde() {
        Node nodeD = new Node(12, 7000,"nodeD");

        assertEquals(nodeD.getModeLabel(), "nodeD");
    }

    @Test
    public void shouldSortNods() {

        Node nodeB = new Node(7, 7000,"nodeB");
        Node nodeC = new Node(0, 123, "nodes.NodeC");
        Node nodeA = new Node(7000, 0,"nodeA");
        Node nodeD = new Node(12, 7000,"nodeD");
        Node nodeE = new Node(800, 0,"nodeE");
        Node nodeF = new Node(70, 7000,"nodeF");

        AddingNodes.addNodes(nodeB);
        AddingNodes.addNodes(nodeC);
        AddingNodes.addNodes(nodeD);
        AddingNodes.addNodes(nodeA);
        AddingNodes.addNodes(nodeF);
        AddingNodes.addNodes(nodeE);

        assertEquals(AddingNodes.sortingList().toString(), "[{id: 7000, parentId: 0, label: 'nodeA'}, {id: 7, parentId: 7000, label: 'nodeB'}, {id: 12, parentId: 7000, label: 'nodeD'}, {id: 70, parentId: 7000, label: 'nodeF'}, {id: 0, parentId: 123, label: 'nodes.NodeC'}, {id: 800, parentId: 0, label: 'nodeE'}]");
    }

    @Test
    public void shouldGetAllParentNodes() {

        Node nodeB = new Node(7, 7000,"nodeB");
        Node nodeC = new Node(0, 123, "nodes.NodeC");
        Node nodeA = new Node(7000, 0,"nodeA");
        Node nodeD = new Node(12, 7000,"nodeD");
        Node nodeE = new Node(800, 0,"nodeE");
        Node nodeF = new Node(7000, 1,"nodeF");

        AddingNodes.addNodes(nodeB);
        AddingNodes.addNodes(nodeC);
        AddingNodes.addNodes(nodeD);
        AddingNodes.addNodes(nodeA);
        AddingNodes.addNodes(nodeE);
        AddingNodes.addNodes(nodeF);
        AddingNodes.sortingList();

        assertEquals(AddingNodes.getParentNodes().toString(), "[{id: 7000, parentId: 0, label: 'nodeA'}, {id: 0, parentId: 123, label: 'nodes.NodeC'}]");
    }

    @Test
    public void shouldGetAllChildNodes() {

        Node nodeB = new Node(7, 7000,"nodeB");
        Node nodeC = new Node(0, 123, "nodes.NodeC");
        Node nodeA = new Node(7000, 0,"nodeA");
        Node nodeD = new Node(12, 7000,"nodeD");
        Node nodeE = new Node(800, 0,"nodeE");
        Node nodeF = new Node(7000, 1,"nodeF");

        AddingNodes.addNodes(nodeB);
        AddingNodes.addNodes(nodeC);
        AddingNodes.addNodes(nodeD);
        AddingNodes.addNodes(nodeA);
        AddingNodes.addNodes(nodeE);
        AddingNodes.addNodes(nodeF);
        AddingNodes.sortingList();

        assertEquals(AddingNodes.getChildNodes().toString(), "[{id: 7, parentId: 7000, label: 'nodeB'}, {id: 12, parentId: 7000, label: 'nodeD'}, {id: 800, parentId: 0, label: 'nodeE'}]");
    }

}
