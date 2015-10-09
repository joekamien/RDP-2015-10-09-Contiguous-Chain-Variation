import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
	private HashMap<Point, Node> nodes = new HashMap<Point, Node>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	private int maxX, maxY;
	
	public Graph (int myMaxX, int myMaxY){
		maxX = myMaxX;
		maxY = myMaxY;
	}
	
	public void addNode (Point location, Node node){
		nodes.put(location, node);
	}
	
	public void addNode (Point location){
		addNode(location, new Node());
	}
	
	public void addEdge (Point location0, Point location1){
		Node node0 = nodes.get(location0);
		Node node1 = nodes.get(location1);
		
		addEdge (node0, node1);
	}
	
	public void generateEdges(){
		for(int y = 0; y < maxY; y++){
			for (int x = 0; x < maxX; x++){
				Point current = new Point(x,y);
				if(nodes.containsKey(current)){
					//there is a node at this location
					Point down = new Point(x,y+1);
					Point right = new Point (x+1, y);
					if(nodes.containsKey(down)){
						addEdge(nodes.get(current), nodes.get(down));
					}
					if(nodes.containsKey(right)){
						addEdge(nodes.get(current), nodes.get(right));
					}
				}
			}
		}
	}
	
	public void addEdge (Node node0, Node node1){
		Edge newEdge = new Edge(node0, node1);
		
		node0.addEdge(newEdge);
		node1.addEdge(newEdge);
		
		edges.add(newEdge);
	}
	
	public boolean isValid(){
		ArrayList<Node> tempNodes = new ArrayList<Node>(nodes.values());
		for(int i = 0; i < tempNodes.size(); i++){
			if (tempNodes.get(i).numActiveEdges() > 2) return false;
		}
		return true;		
	}
	
	public int numChains(){
		/*
		 * number of chains should be equal to
		 * number of nodes - number of active edges
		 */
		int numNodes = nodes.size();
		int numActiveEdges = 0;
		for (int i = 0; i < edges.size(); i++){
			if(edges.get(i).isActive) numActiveEdges++;
		}
		return numNodes - numActiveEdges;
	}
	
	public String toString(){
		if(nodes.size() == 0) return "Graph contains no nodes.";
		
		String s = "";
		for(int y = 0; y < maxY; y++){
			for (int x = 0; x < maxX; x++){
				Point p = new Point (x,y);
				if(nodes.containsKey(p)){
					s += "X";
				}
				else{
					s += " ";
				}
			}
			s += "\n";
		}
		return s;
	}
	
	private void incrementEdges(){
		incrementEdges(edges.size() - 1);
	}
	
	private void incrementEdges(int level){
		if(level < 0 || level >= edges.size()) return;
		
		Edge current = edges.get(level);
		if(current.isActive == false){
			current.isActive = true;
		}
		else{
			current.isActive = false;
			incrementEdges(level - 1);
		}
	}
	
	private boolean atMaxIncrement(){
		for(int i = 0; i < edges.size(); i++){
			if (!edges.get(i).isActive) return false;
		}
		return true;
	}
	
	public int minChains(){
		int min = Integer.MAX_VALUE;
		while(true){
			if(isValid()){
				min = Integer.min(min, numChains());
			}
			if(atMaxIncrement()){
				break;
			}
			incrementEdges();
		}
		return min;
	}
}
