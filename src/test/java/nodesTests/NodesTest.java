package nodesTests;

import nodes.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.*;

public class NodesTest {

    @BeforeEach
    public void clearMap() {
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

        AddingNodes addingNodes = new AddingNodes();

        addingNodes.addNodes(nodeA);
        addingNodes.addNodes(nodeB);
        addingNodes.addNodes(nodeC);
        addingNodes.addNodes(nodeD);
        addingNodes.addNodes(nodeE);
        addingNodes.addNodes(nodeF);
        addingNodes.addNodes(nodeG);
        assertEquals(addingNodes.nodeList.toString(), "[node { identity: 700, parentIdentity 0, modeLabel 'nodeA', childNodes [] }, node { identity: 70, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 9, parentIdentity 123, modeLabel 'nodes.NodeC', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodes.NodeD', childNodes [] }, node { identity: 25, parentIdentity 7000, modeLabel 'NOdeE', childNodes [] }, node { identity: 3, parentIdentity 0, modeLabel 'nodes.NodeF', childNodes [] }, node { identity: 10, parentIdentity 3, modeLabel 'nodes.NodeG', childNodes [] }]");
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

//    @Test
//    public void shouldSortNods() {
//
//        Node nodeB = new Node(7, 7000,"nodeB");
//        Node nodeC = new Node(80, 123, "nodes.NodeC");
//        Node nodeA = new Node(7000, 0,"nodeA");
//        Node nodeD = new Node(12, 7000,"nodeD");
//        Node nodeE = new Node(800, 0,"nodeE");
//        Node nodeF = new Node(70, 7000,"nodeF");
//        AddingNodes addingNodes = new AddingNodes();
//        addingNodes.addNodes(nodeB);
//        addingNodes.addNodes(nodeC);
//        addingNodes.addNodes(nodeD);
//        addingNodes.addNodes(nodeA);
//        addingNodes.addNodes(nodeF);
//        addingNodes.addNodes(nodeE);
//
//        assertEquals(addingNodes.sortingList().toString(), "[{id: 7000, parentId: 0, label: 'nodeA'}, {id: 7, parentId: 7000, label: 'nodeB'}, {id: 12, parentId: 7000, label: 'nodeD'}, {id: 70, parentId: 7000, label: 'nodeF'}, {id: 0, parentId: 123, label: 'nodes.NodeC'}, {id: 800, parentId: 0, label: 'nodeE'}]");
//    }

    @Test
    public void shouldGetAllParentNodes() {

        Node nodeB = new Node(7, 7000,"nodeB");
        Node nodeC = new Node(80, 123, "nodes.NodeC");
        Node nodeA = new Node(7000, 0,"nodeA");
        Node nodeD = new Node(12, 7000,"nodeD");
        Node nodeE = new Node(800, 0,"nodeE");
        Node nodeF = new Node(70, 1,"nodeF");

        AddingNodes addingNodes = new AddingNodes();

        addingNodes.addNodes(nodeB);
        addingNodes.addNodes(nodeC);
        addingNodes.addNodes(nodeD);
        addingNodes.addNodes(nodeA);
        addingNodes.addNodes(nodeE);
        addingNodes.addNodes(nodeF);

        assertEquals(addingNodes.getParentNodes().toString(), "[node { identity: 7000, parentIdentity 0, modeLabel 'nodeA', childNodes [] }, node { identity: 800, parentIdentity 0, modeLabel 'nodeE', childNodes [] }]");
    }

    @Test
    public void shouldGetAllChildNodes() {

        Node nodeB = new Node(7, 7000,"nodeB");
        Node nodeC = new Node(45, 123, "nodes.NodeC");
        Node nodeA = new Node(7000, 0,"nodeA");
        Node nodeD = new Node(12, 7000,"nodeD");
        Node nodeE = new Node(800, 0,"nodeE");
        Node nodeF = new Node(70, 12,"nodeF");
        AddingNodes addingNodes = new AddingNodes();
        addingNodes.addNodes(nodeB);
        addingNodes.addNodes(nodeC);
        addingNodes.addNodes(nodeD);
        addingNodes.addNodes(nodeA);
        addingNodes.addNodes(nodeE);
        addingNodes.addNodes(nodeF);

        assertEquals(addingNodes.getChildNodes().toString(), "[node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 45, parentIdentity 123, modeLabel 'nodes.NodeC', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }, node { identity: 70, parentIdentity 12, modeLabel 'nodeF', childNodes [] }]");
    }

    @Test
    public void shouldMapNodes() {

        Node nodeB = new Node(7, 7000,"nodeB");
        Node nodeC = new Node(80, 123, "NodeC");
        Node nodeA = new Node(7000, 0,"nodeA");
        Node nodeD = new Node(12, 7000,"nodeD");
        Node nodeE = new Node(800, 0,"nodeE");
        Node nodeF = new Node(70, 800,"nodeF");
        AddingNodes addingNodes = new AddingNodes();

        addingNodes.addNodes(nodeB);
        addingNodes.addNodes(nodeC);
        addingNodes.addNodes(nodeD);
        addingNodes.addNodes(nodeA);
        addingNodes.addNodes(nodeE);
        addingNodes.addNodes(nodeF);
        addingNodes.getParentNodes();
        addingNodes.getChildNodes();
        for (CreatingNode node: addingNodes.mappingNodes()){
            System.out.println(node.getIdentity());
            System.out.println(node.getModeLabel());
            System.out.println("phakathi");
        }
        assertEquals(addingNodes.mappingNodes().toString(), "[node { identity: 7000, parentIdentity 0, modeLabel 'nodeA', childNodes [node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }, node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }, node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }, node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }] }, node { identity: 800, parentIdentity 0, modeLabel 'nodeE', childNodes [node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }, node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }, node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }, node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }] }]");
    }

   @Test
   public void shouldPrintNodes() {

       Node nodeB = new Node(7, 7000,"nodeB");
       Node nodeC = new Node(80, 123, "NodeC");
       Node nodeA = new Node(7000, 0,"nodeA");
       Node nodeD = new Node(12, 7000,"nodeD");
       Node nodeE = new Node(800, 0,"nodeE");
       Node nodeF = new Node(70, 800,"nodeF");
       AddingNodes addingNodes = new AddingNodes();

       addingNodes.addNodes(nodeB);
       addingNodes.addNodes(nodeC);
       addingNodes.addNodes(nodeD);
       addingNodes.addNodes(nodeA);
       addingNodes.addNodes(nodeE);
       addingNodes.addNodes(nodeF);
       addingNodes.getParentNodes();
       addingNodes.getChildNodes();
       for (CreatingNode node: addingNodes.mappingNodes()){
           System.out.println(node);
       }
       assertEquals(addingNodes.printTree(addingNodes.mappingNodes()), "[node { identity: 7000, parentIdentity 0, modeLabel 'nodeA', childNodes [node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }, node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }, node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }, node { identity: 7, parentIdentity 7000, modeLabel 'nodeB', childNodes [] }, node { identity: 12, parentIdentity 7000, modeLabel 'nodeD', childNodes [] }] }, node { identity: 800, parentIdentity 0, modeLabel 'nodeE', childNodes [node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }, node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }, node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }, node { identity: 70, parentIdentity 800, modeLabel 'nodeF', childNodes [] }] }]");
   }


    @Test
    public void shouldBeAbleToWriteToJSONFile() throws IOException {

        try (FileReader fileReader = new FileReader("NodesTree.json"))
        {
            JSONParser jsonParser = new JSONParser();
            AddingNodes addingNodes = new AddingNodes();
            JSONArray jsonArray = new JSONArray();
            PrintWriter pw = new PrintWriter("NodesTree.json");

            Node nodeA = new Node(700, 0,"nodeA");
            Node nodeB = new Node(70, 7000,"nodeB");
            Node nodeC = new Node(9, 123, "nodes.NodeC");
            Node nodeD = new Node(12, 7000, "nodes.NodeD");
            Node nodeE = new Node(25, 7000, "NOdeE");
            Node nodeF = new Node(3,0, "nodes.NodeF");
            Node nodeG = new Node(10, 3, "nodes.NodeG");

            addingNodes.addNodes(nodeA);
            addingNodes.addNodes(nodeB);
            addingNodes.addNodes(nodeC);
            addingNodes.addNodes(nodeD);
            addingNodes.addNodes(nodeE);
            addingNodes.addNodes(nodeF);
            addingNodes.addNodes(nodeG);
            addingNodes.getParentNodes();
            addingNodes.getChildNodes();
            for (CreatingNode node: addingNodes.mappingNodes()){
                System.out.println(node);
            }

            jsonArray.add(addingNodes.mappingNodes());

            pw.write(jsonArray.toJSONString());

            pw.flush();
            pw.close();

            assertEquals(fileReader.ready(), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

}
