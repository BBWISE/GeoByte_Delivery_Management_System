import java.util.*;

class Dijkstra {

	/* If n is the number of vertices of g and m the number of edges of g,
	 * the asymptotic time complexity of my solution is in
	 * O(n^2) because a for loop is nested inside a while loop
	 */
	public static double totalDistance =0;
	@SuppressWarnings({ })
	public static LinkedList<Integer> route(WeightedGraph g, int origin, int destination) {
		//int [] nodes  = new int[g.size()];
		boolean [] visited = new boolean[g.size()];
		
		double [] shortestDistance = new double[g.size()];
		int [] previousNode = new int[g.size()];
		
		Arrays.fill(visited, false);
		Arrays.fill(shortestDistance, Integer.MAX_VALUE);
		Arrays.fill(previousNode, -1);
		
		
		Queue<Integer> Q = new PriorityQueue<Integer>();
		
		Q.add(origin);
		
		shortestDistance[origin] = 0;
		previousNode[origin]=origin;
		
		while(!Q.isEmpty()) {
			
			int element = Q.poll();
			visited[element] = true;
			
			for(WeightedEdge e : g.successors(element)) {
				if(e.target!=null && visited[e.target]!=true) {
					Q.add(e.target);
					if(shortestDistance[e.target]>=(e.distance+shortestDistance[element])) {
						shortestDistance[e.target] = e.distance+shortestDistance[element];
						previousNode[e.target] = element;
					}
				}
				
			}
		}
		totalDistance = shortestDistance[destination];
		LinkedList<Integer> rRoute = new LinkedList<Integer>();
		int previous = destination;
		rRoute.add(previous);
		while(previous!=origin) {
			rRoute.add(previousNode[previous]);
			previous = previousNode[previous];
		}
		LinkedList<Integer> route = new LinkedList<Integer>();
		
			for(int i=rRoute.size()-1;i>=0;i--) {
				route.add(rRoute.get(i));
			}
		return route;
	}
}

