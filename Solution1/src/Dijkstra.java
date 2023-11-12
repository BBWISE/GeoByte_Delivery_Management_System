import java.util.*;

class Dijkstra {

	/* If n is the number of vertices of g and m the number of edges of g,
	 * the asymptotic time complexity of my solution is in
	 * O(n^2) because a for loop is nested inside a while loop
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	static int[] route(WeightedGraph g, int origin, int destination) {
		
		System.out.println(g.size());
		final int n = g.size();
		
		int[] distances = new int[n];
		
		boolean visit[] = new boolean[n];
		
		Arrays.fill(distances, -1);
		Arrays.fill(visit, false);
		
		Queue<Integer> Q = new PriorityQueue(n);
		Q.add(origin);
		distances[origin] = 0;//System.out.println("Queue: "+Q);
		while (!Q.isEmpty()) {
			int v = (int) Q.poll();
			
			int index = -1;
			for (int i = origin; i < n; i++) {
				if (distances[i] == v && visit[i] == false) {
					index = i;
					break;
				}
			}
			if (index > -1 && visit[index] == false) {
				visit[index] = true;
				int d = 0;

				for (WeightedEdge e : g.successors(index)) {
					d = (e.distance + v);
					System.out.print(e.distance+" = "+d);
					if (distances[e.target] == -1 || distances[e.target] > d) {
						distances[e.target] = d;
						Q.add(d);
					}

				}

			}

		}

		return distances;
	}
	
}

