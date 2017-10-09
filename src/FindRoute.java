import java.io.*;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import  java.util.ArrayList;

public class FindRoute{

    public static void main(String[] args){

        if(args.length != 3){
            System.err.println("Not enough command line parameters provided. Please provide 3 parameters: \n 1. inputfileName \n 2. Source \n 3. Destination ");
            return;
        }
        String eachLine = null;
        BufferedReader br = null;
        HashMap <String,List<Node>> graph = new HashMap<String, List<Node>>();
        LinkedList<Node> unExploredNodes = new LinkedList<Node>();
        ArrayList<Node> listOfNodesVisited = new ArrayList<Node>();

        try{
            File inputFile = new File(args[0]);
            br = new BufferedReader(new FileReader(args[0]));
            while((eachLine = br.readLine()) != null && !(eachLine.equals("END OF INPUT"))){
                String[] components = eachLine.split(" ");
                InputGraph.constructGraph(graph, components);
            }

            InputGraph.addSuccessors(graph);

            if(!(graph.containsKey(args[1]))){
                System.out.println("No solution exists as there is no source with name - " + args[1]);
                return;
            }

            if(!(graph.containsKey(args[2]))){
                System.out.println("No solution exists as there is no goal with name - " + args[2]);
                return;
            }

            if(args[1].equals(args[2])){
                System.out.println("distance : 0 km " + "\n Route: \n " + args[1] + " to " + args[2] + ", 0 km ");
                return;
            }

            UniformCostSearch.findOptimalPathUsingUniformCostSearch(graph, args[1], args[2], unExploredNodes, listOfNodesVisited);
            br.close();

        }catch(FileNotFoundException fnfe){
            System.err.println("No File found with the given file name!");
        }catch(IOException ioe){
            System.err.println("Unable to read from the given input file!");
        }
    }
}
