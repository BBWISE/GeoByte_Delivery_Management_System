class WeightedEdge {
  public int weight;
  public int target;

  public WeightedEdge(int nweight, int ntarget)
  {
    weight = nweight;
    target = ntarget;
  }

  public WeightedEdge(WeightedEdge other)
  {
    weight = other.weight;
    target = other.target;
  }
}
