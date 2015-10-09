import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph {
	private HashMap<Point, Node> nodes;
	private ArrayList<Edge> edges;
	
	public void addNode (Point location, Node node){
		nodes.put(location, node);
	}
	
	public void addEdge (Point location0, Point location1){
		Node node0 = nodes.get(location0);
		Node node1 = nodes.get(location1);
		
		Edge newEdge = new Edge(node0, node1);
		
		node0.addEdge(newEdge);
		node1.addEdge(newEdge);
		
		edges.add(newEdge);
	}
	
	public boolean isValid(){
		ArrayList<Node> tempNodes = new ArrayList(nodes.values());
		for(int i = 0; i < tempNodes.size(); i++){
			if (tempNodes.get(i).numActiveEdges() > 2) return false;
		}
		return true;		
	}
}
