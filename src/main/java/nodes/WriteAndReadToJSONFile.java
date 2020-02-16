package nodes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteAndReadToJSONFile {
    public static void main(String[] args) {
//        FileReader reader = new FileReader("NodesTree.json")
        JSONParser jsonParser = new JSONParser();
        try  {
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
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

            jsonArray.add(addingNodes.nodeList);
            PrintWriter pw = new PrintWriter("NodesTree.json");
            pw.write(jsonArray.toJSONString());

            pw.flush();
            pw.close();
//            Object object = jsonParser.parse(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
