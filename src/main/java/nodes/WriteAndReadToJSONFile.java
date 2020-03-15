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
    public static void main(final String[] args) {
        final JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("NodesTree.json"))
        {
            final JSONObject jsonObject = new JSONObject();
            final JSONArray jsonArray = new JSONArray();
            final Node nodeB = new Node(7, 7000,"nodeB");
            final Node nodeC = new Node(80, 123, "NodeC");
            final Node nodeA = new Node(7000, 0,"nodeA");
            final Node nodeD = new Node(12, 7000,"nodeD");
            final Node nodeE = new Node(800, 0,"nodeE");
            final Node nodeF = new Node(70, 800,"nodeF");
            final AddingNodes addingNodes = new AddingNodes();

            addingNodes.addNodes(nodeB);
            addingNodes.addNodes(nodeC);
            addingNodes.addNodes(nodeD);
            addingNodes.addNodes(nodeA);
            addingNodes.addNodes(nodeE);
            addingNodes.addNodes(nodeF);

            jsonArray.add(addingNodes.nodeList);
            final PrintWriter pw = new PrintWriter("NodesTree.json");
            pw.write(jsonArray.toJSONString());

            pw.flush();
            pw.close();
            final Object object = jsonParser.parse(String.valueOf(reader.read()));
            final JSONObject jsonArray1 = (JSONObject) object;
            jsonArray.forEach(list -> {
                System.out.println(list.toString());
            } );
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
