import java.util.Comparator;

public class SortByCost implements Comparator<Node>{
    @Override
    public int compare(Node node1, Node node2) {
    	return (node1.getCummulativeCost() < node2.getCummulativeCost()) ? -1: (node1.getCummulativeCost() > node2.getCummulativeCost()) ? 1:0;
    }
}
