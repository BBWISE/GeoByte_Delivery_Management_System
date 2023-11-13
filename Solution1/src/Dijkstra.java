import java.util.*;

class Dijkstra {

	/* If n is the number of vertices of g and m the number of edges of g,
	 * the asymptotic time complexity of my solution is in
	 * O(n^2) because a for loop is nested inside a while loop
	 */
	/*
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
	
}*/

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
		System.out.println(g.size()+" ...."+ origin+" = "+destination);
		
		/*System.out.println("\n\n Graph:\n");
		int i= 0;
		for(LinkedList<WeightedEdge> e: g.successors()) {
			System.out.print(g);
			i ++;
		}*/
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

