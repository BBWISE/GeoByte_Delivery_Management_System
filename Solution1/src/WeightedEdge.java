class WeightedEdge {
	
	public String locationName;
	public Integer clearingCost;
	public Integer distance;
	public Integer target;
	
	public WeightedEdge(String nlocationName, Integer nclearingCost, Integer ndistance, Integer ntarget){
		locationName = nlocationName;
		clearingCost = nclearingCost;
		distance = ndistance;
		target = ntarget;
	}
	
	public WeightedEdge(WeightedEdge other) {
		locationName = other.locationName;
		clearingCost = other.clearingCost;
		distance = other.distance;
		target = other.target;
	}
}
