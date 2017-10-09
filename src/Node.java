import java.util.List;

public class Node {

    String state;
    int cost;
    int cummulativeCost = 10000000;
    List<Node> successors;
    Node parent;

    public int getCummulativeCost() {
        return cummulativeCost;
    }

    public void setCummulativeCost(int cummulativeCost) {
        this.cummulativeCost = cummulativeCost;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setSuccessors(List<Node> successors) {
        this.successors = successors;
    }

    public int getCost() {
        return cost;
    }

    public List<Node> getSuccessors() {
        return successors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;
        return getState().equals(node.getState());
    }

    @Override
    public int hashCode() {
        int result = getState().hashCode();
        return result;
    }
}

