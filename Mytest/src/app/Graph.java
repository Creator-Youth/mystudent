package app;

import java.util.TreeSet;

public class Graph 
{
	private  int  V;//顶点数目
	private  int E;     //边的数目
    private TreeSet<Integer>[] adj;//临接表
    
    @SuppressWarnings("unchecked")
	public Graph(int V)
    {
    	this.V=V;
    	this.E=0;
    	adj=(TreeSet<Integer>[])new TreeSet[V];
    	for(int v=0;v<V;v++)
    	{
    		adj[v]=new TreeSet<Integer>();
    	}
    }

	public int getV() {
		return V;
	}

	public int getE() {
		return E;
	}

	public void addEdge(int v,int w)
	{
	   adj[v].add(w);
	   adj[w].add(v);
	   E++;
	}
	
	public TreeSet<Integer> getadj(int v)
	{
		return adj[v];
	}
	
    
	
}
