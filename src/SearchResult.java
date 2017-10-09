import java.util.ArrayList;

public class SearchResult {

    public static void getResultDetails(String source, Node goalNode, ArrayList<Node> listOfNodesVisited){


        int totalCost = 0;
        int sizeOfVisitedList = listOfNodesVisited.size()-1;

        Node nextNode = null;
        ArrayList<Node> listOfNodesinResultPath = new ArrayList<Node>();

        for(int j=sizeOfVisitedList ; j>=0; j--){
            if (listOfNodesVisited.get(j).equals(goalNode.getParent())) {
                totalCost = goalNode.getCost() + listOfNodesVisited.get(j).getCummulativeCost();
                nextNode = goalNode.getParent();
                listOfNodesinResultPath.add(goalNode);
                continue;
            }
            else if (null != nextNode && listOfNodesVisited.get(j).equals(nextNode.getParent())) {
                listOfNodesinResultPath.add(nextNode);
                nextNode= nextNode.getParent();
            }

        }

        System.out.println("distance: " + totalCost + " km");
	System.out.println("route: ");

        for (int i=listOfNodesinResultPath.size()-1; i>=0; i--){
            System.out.println(listOfNodesinResultPath.get(i).getParent().getState()
                    + " to " + listOfNodesinResultPath.get(i).getState()
                    + ", " + listOfNodesinResultPath.get(i).getCost() + " km");
        }

    }
}
