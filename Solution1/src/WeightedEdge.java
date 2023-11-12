class WeightedEdge {
	
	public Integer clearingCost;
	public Integer distance;
	public Integer target;
	
	public WeightedEdge(Integer nclearingCost, Integer ndistance, Integer ntarget){
		clearingCost = nclearingCost;
		distance = ndistance;
		target = ntarget;
	}
	
	public WeightedEdge(WeightedEdge other) {
		clearingCost = other.clearingCost;
		distance = other.distance;
		target = other.target;
	}
}
