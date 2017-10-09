import java.util.*;

public class UniformCostSearch {

    public static void findOptimalPathUsingUniformCostSearch(HashMap<String, List<Node>> graph, String source, String goal,
                                                             LinkedList<Node> fringe, ArrayList<Node> listOfNodesVisited){

        Node sourceNode = new Node();
        sourceNode.setState(source);
        sourceNode.setSuccessors(graph.get(source));
        sourceNode.setCummulativeCost(0);

        Node goalNode = new Node();
        goalNode.setState(goal);

        fringe.add(sourceNode);

        int i = 0;

        boolean isNodeAddedToFringe = false;

        while (! fringe.isEmpty()){

            Node nodePoppedOut = fringe.remove();

            if(! listOfNodesVisited.contains(nodePoppedOut)){
                if(goal.equals(nodePoppedOut.getState())){
                    SearchResult.getResultDetails(source, nodePoppedOut, listOfNodesVisited);
                    return;
                }

                if(null == nodePoppedOut.getSuccessors()){
                    continue;
                }
                for(Node node : nodePoppedOut.getSuccessors()){
                    if(! listOfNodesVisited.contains(node)){
                        if(node.getCummulativeCost() > node.getCost()+nodePoppedOut.getCummulativeCost()){
                            node.setCummulativeCost(nodePoppedOut.getCummulativeCost()+node.getCost());
                        }
                        isNodeAddedToFringe = true;
                        fringe.add(node);
                        node.setParent(nodePoppedOut);

                    }
                }
                if(isNodeAddedToFringe){
                    listOfNodesVisited.add(nodePoppedOut);
                }
                Collections.sort(fringe, new SortByCost());
            }
        }

        System.out.println(" distance : infinity");
        System.out.println(" route : none");

    }
}
