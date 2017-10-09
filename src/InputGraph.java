import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class InputGraph {

    public static void constructGraph(HashMap<String, List<Node>> graph, String[] components) {

        if(graph.containsKey(components[0])){
            List<Node> listOfNodes = graph.get(components[0]);
            Node newNode = new Node();
            newNode.setState(components[1]);
            newNode.setCost(Integer.parseInt(components[2]));
            listOfNodes.add(newNode);
        }
        if (graph.containsKey(components[1])){
            List<Node> listOfNodes = graph.get(components[1]);
            Node newNode = new Node();
            newNode.setState(components[0]);
            newNode.setCost(Integer.parseInt(components[2]));
            listOfNodes.add(newNode);
        }
        if (! graph.containsKey(components[0])) {
            List<Node> listOfNodes = new LinkedList<Node>();
            Node newNode = new Node();
            newNode.setState(components[1]);
            newNode.setCost(Integer.parseInt(components[2]));
            listOfNodes.add(newNode);
            graph.put(components[0], listOfNodes);
        }
        if (! graph.containsKey(components[1])){
            List<Node> listOfNodes = new LinkedList<Node>();
            Node newNode = new Node();
            newNode.setState(components[0]);
            newNode.setCost(Integer.parseInt(components[2]));
            listOfNodes.add(newNode);
            graph.put(components[1], listOfNodes);
        }
    }

    public static void addSuccessors(HashMap<String, List<Node>> graph){
        for(String city : graph.keySet()){
            List<Node> nodeList = graph.get(city);
            for(Node node : nodeList){
                node.setSuccessors(graph.get(node.getState()));
            }
        }
    }

}
