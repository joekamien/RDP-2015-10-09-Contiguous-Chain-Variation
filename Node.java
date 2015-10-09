import java.util.ArrayList;

public class Node {
	private ArrayList<Edge> edges = new ArrayList(4);
	
	public void addEdge(Edge myEdge){
		edges.add(myEdge);
	}
}
