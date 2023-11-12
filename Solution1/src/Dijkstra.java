class Dijkstra {

  // If n is the number of vertices of g and m the number of edges of g,
  // the asymptotic time complexity of my solution is in
  // 
  //    O(n^2)
  //
  // because a for loop is nested inside a while loop
  @SuppressWarnings({ "rawtypes", "unchecked" })
static int[] distances(WeightedGraph g, int source)
  {
    final int n = g.size();
    int[] distances = new int[n];
    // Your code goes here
    
	boolean visit [] = new boolean[n];
	for(int i=0;i<n;i++) {
		distances[i]= -1;
		visit[i]=false;
	}
	PriorityQueue Q = new MyPriorityQueue(n);
		Q.enqueue(0, 0);
		distances[source] = 0;
	while(!Q.isEmpty()) {
		int v = (int) Q.dequeue();
		int index = -1;
		for(int i=0;i<n;i++) {
			if(distances[i]==v && visit[i]==false) {
				index = i;
				break;
			}
		}
		if(index > -1 && visit[index] == false ) {
			visit[index] = true;
			int d = 0;
			
			for(WeightedEdge e : g.successors(index)) {
				d=(e.weight+ v);
				if(distances[e.target] == -1 || distances[e.target]>d) {
					distances[e.target] = d;
					Q.enqueue(d, d);
				}
				
			}
			
		}
		
	}
	
    return distances;
  }

  @SuppressWarnings({ "rawtypes", "unchecked" })
static int[] times(WeightedGraph g, int source)
  {
    final int n = g.size();
    int[] times = new int[n];
    // Your code goes here
    
    boolean visit [] = new boolean[n];
    int [] distances = new int[n];
	for(int i=0;i<n;i++) {
		times[i]= -1;
		visit[i]=false;
		distances[i]=-1;
	}
	PriorityQueue Q = new MyPriorityQueue(n);
		times[source] = 0;
		visit[source] = true;
		distances[source]=0;
	
	for(WeightedEdge e : g.successors(source)) {
		int d = (e.weight);
		Q.enqueue(d, d);
		distances[e.target] = d;
		times[e.target] = (e.weight + 1);
	}
	
	while(!Q.isEmpty()) {
		int v = (int) Q.dequeue();
		int index = -1;
		for(int i=0;i<n;i++) {
			if(distances[i]== v && visit[i]==false) {
				index = i;
				break;
			}
		}
		if(index > -1 && visit[index] == false ) {
			visit[index] = true;
			int d = 0;
			
			for(WeightedEdge e : g.successors(index)) {
				d=(e.weight+ v);
				if(distances[e.target] == -1 || distances[e.target]>d) {
					distances[e.target] = d;
					times[e.target] = (times[index]+1);
					Q.enqueue(d, d);
				}
				
			}
			
		}
		
	}
    return times;
  }
}
