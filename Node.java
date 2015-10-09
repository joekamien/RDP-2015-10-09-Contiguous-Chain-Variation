import java.util.ArrayList;

public class Node {
	private ArrayList<Edge> edges = new ArrayList(4);
	
	public void addEdge(Edge myEdge){
		edges.add(myEdge);
	}
	
	public int numActiveEdges(){
		int sum = 0;
		for (int i = 0; i < edges.size(); i++){
			if(edges.get(i).isActive) sum++;
		}
		return sum;
	}
}
