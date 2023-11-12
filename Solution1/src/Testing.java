import java.util.*;
//import java.util.function.Function;

public class Testing {

	public static void main(String[] args) throws Exception {

		ArrayList<LinkedList<WeightedEdge>> graph = new ArrayList<>(0);

		LinkedList<WeightedEdge> a = new LinkedList<>(); // 0
			a.add(new WeightedEdge(40, 4, 1));
			a.add(new WeightedEdge(35, 2, 2));
		LinkedList<WeightedEdge> b = new LinkedList<>(); // 1
			b.add(new WeightedEdge(40, 5, 3));
		LinkedList<WeightedEdge> c = new LinkedList<>(); // 2
			c.add(new WeightedEdge(44, 4, 3));
			c.add(new WeightedEdge(36, 3, 4));
		LinkedList<WeightedEdge> d = new LinkedList<>(); // 3
			d.add(new WeightedEdge(36, 2, 4));
		LinkedList<WeightedEdge> e = new LinkedList<>(); // 4
			d.add(new WeightedEdge(null, null, null));
		
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		
		WeightedGraph gg = new WeightedGraph(graph);
		
		@SuppressWarnings("rawtypes")
		LinkedList arr = Dijkstra.route(gg, 1, 4);
		
		System.out.print("Optimum route is: ");
		for (int i = 0; i < arr.size(); i++) {
			
			System.out.print(arr.get(i));
			if(i!=arr.size()-1) {
				System.out.print(" -> ");
			}
		}
		
	}
	
	//public LinkedList w

}
