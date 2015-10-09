
public class Edge {
	public boolean isActive = false;
	private Node[] nodes = new Node[2];
	
	public Edge(Node myNode0, Node myNode1){
		nodes[0] = myNode0;
		nodes[1] = myNode1;
	}
}
