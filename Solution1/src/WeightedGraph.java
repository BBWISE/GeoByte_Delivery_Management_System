import java.util.*;
//import java.util.function.*;

class WeightedGraph {
	protected ArrayList<LinkedList<WeightedEdge>> successorsLists;

	public WeightedGraph(ArrayList<LinkedList<WeightedEdge>> i) {
		successorsLists = new ArrayList<LinkedList<WeightedEdge>>();
		for (Collection<WeightedEdge> es : i) {
			LinkedList<WeightedEdge> myEdgeList = new LinkedList<WeightedEdge>();
			for (WeightedEdge e : es)
				myEdgeList.add(new WeightedEdge(e));
			successorsLists.add(myEdgeList);
		}
	}

	public WeightedGraph(Collection<Collection<WeightedEdge>> i) {
		successorsLists = new ArrayList<LinkedList<WeightedEdge>>();
		for (Collection<WeightedEdge> es : i) {
			LinkedList<WeightedEdge> myEdgeList = new LinkedList<WeightedEdge>();
			for (WeightedEdge e : es)
				myEdgeList.add(new WeightedEdge(e));
			successorsLists.add(myEdgeList);
		}
	}

	
	public int size() {
		return successorsLists.size();
	}

	public LinkedList<WeightedEdge> successors(int source) {
		LinkedList<WeightedEdge> res = new LinkedList<WeightedEdge>();
		for (WeightedEdge e : successorsLists.get(source))
			res.add(new WeightedEdge(e));
		return res;
	}
}
