import java.util.*;

public class DirectedGraphNode{
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	DirectedGraphNode(int x){
		label = x;
		neighbors = new ArrayList<DirectedGraphNode>();
	}
}
