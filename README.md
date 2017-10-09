# Uninformed-Search-Algorithms
implementations of various uninformed Search Algorithms

All the programs implemented are based on Java SE 6

README


1. This program implements Uniform-Cost Search Algorithm(Uninformed Search)
2. The Program is written in JAVA PROGRAMMING LANGUAGE


CODE STRUCTURE:
===============

Totally 6 source code files:

1. FindRoute.java
2. Node.java
3. InputGraph.java
4. UniformCostSearch.java
5. SortByCost.java
6. SearchResult.java

FindRoute.java - 	is the main class file where the main() method exists, from where the program execution starts.
		      	The main method reads the command line arguments and delegates the call to subsequent classes.

Node.java -		Is the implementation class for representing a Node. It can contain information regarding its state, cost, its successors(children), its parent
			It also implements hashCode() and equals() methods over the state field.

InputGraph.java -	Is the class used to construct a graph out of the given input.txt file.
			It has 2 methods: 
				i. “constructGraph() “ - constructs a graph as a HashMap, with key as State and value as list of its successor Nodes 
				ii. “addSuccessors() “ - this method adds successors to each of the nodes present in the graph that was constructed using the above method


UniformCostSearch.java -	This class is where the Uniform cost search algorithm is implemented. It has a method :
				“findOptimalPathUsingUniformCostSearch() “ - which finds out if a path from the given source state to goal state exists or not.

SortByCost.java - 		This class is the comparator (has a method compare())used to sort the list of nodes in the fringe based on cost whenever we add new nodes to the fringe.
				The compare method in this class actually does the comparison amongst the nodes in the fringe & sort them in the increasing order of cost. That is the lowest cost node will 				 be a the beginning of the fringe.

SearchResult.java - 	This class has method “ getResultDetails() “ that generates the optimal result path. It backtracks the the listOfNodesVisited  and constructs a listOfNodesinResultPath which will 			contain the list of nodes that will have to traversed to reach from source to goalState. And displays the path obtained in the desired output format by iterating the listOfNodesinResultPath.

  							
Program Flow: 
=============

Read InputFile.txt ————> construct inputGraph ————> run UnformCostSearch Algorithm over the inputGraph ————>  Display Result.


PLEASE FOLLOW THE INSTRUCTIONS BELOW TO RUN THE APPLICATION.
=============================================================

Important Note: All inputs are case Sensitive!

Step 1:	Go to the directory where all the source code is present.
		Generate class files(binary files) into a directory from the source code. Run the below command:
		
			javac -d /home/user/uniformCostSearch/binaryFiles *.java

		This will generate the binary files into the directory “/home/user/uniformCostSearch/binaryFiles ” of all the source files present in the current directory.


Step 2: 	Go to directory “/home/user/uniformCostSearch/binaryFiles” where the binary files are present. 
	  
		Place the “ input.txt “ file in this directory.


Step 3: 	To Run the program, please make sure you are in the directory where all the binary files and the input.txt file is present.
	   	
		Run the below command from to execute the program:

			java FinRoute input.txt sourceState goalState

		This will generate the output in the desired manner. For example:
	
			java FindRoute input.txt Manchester Bristol

		Output:
			distance: 169 km
			route:
			Manchester to Birmingham, 84 km
			Birmingham to Bristol, 85 km


