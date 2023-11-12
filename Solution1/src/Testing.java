import java.util.*;
//import java.util.function.Function;

public class Testing {

	public static void main(String[] args) throws Exception {

		ArrayList<LinkedList<WeightedEdge>> graph = new ArrayList<>(0);

		LinkedList<WeightedEdge> a = new LinkedList<>();
			a.add(new WeightedEdge("A", 35, 2, 3));
			a.add(new WeightedEdge("A", 40, 2, 2));
		LinkedList<WeightedEdge> b = new LinkedList<>();
			b.add(new WeightedEdge("B", 40, 5, 4));
		LinkedList<WeightedEdge> c = new LinkedList<>();
			c.add(new WeightedEdge("C", 36, 3, 5));
			c.add(new WeightedEdge("C", 44, 4, 4));
		LinkedList<WeightedEdge> d = new LinkedList<>();
			d.add(new WeightedEdge("D", 36, 2, 5));
		LinkedList<WeightedEdge> e = new LinkedList<>();
			d.add(new WeightedEdge("E", null, null, null));
		
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);

		WeightedGraph gg = new WeightedGraph(graph);

		int arr[] = Dijkstra.route(gg, 1, 4);
		System.out.println("Result");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}

	}

}
