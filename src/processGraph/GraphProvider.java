package processGraph;

import android.annotation.SuppressLint;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@SuppressLint("UseSparseArrays")
public class GraphProvider {
	int maxUid;
	GraphNode rootNode;
	Map<Integer, GraphNode> hashIdNode;

	public GraphProvider() {
		this.maxUid = 0;
		rootNode = new GraphNode(0, "root Node", "description", "actor", 0, 0,
				new ArrayList<Integer>(), new ArrayList<Integer>());
		hashIdNode = new HashMap<Integer, GraphNode>();
		hashIdNode.put(rootNode.getUid(), rootNode);
	}

	public int addNewNode(String title, String description, String actor,
			int duration, int cost, int[] childs, int[] parents) {
		maxUid += 1;
		GraphNode newNode = new GraphNode(maxUid, title, description, actor,
				duration, cost, arrayToList(parents), arrayToList(childs));
		insertChildToParents(parents, newNode.getUid());
		insertParentToChilds(childs, newNode.getUid());
		return maxUid;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Pair<Integer, String>> getAllActivititesTitle(){
		List<Pair<Integer, String>> idTitle = new ArrayList<Pair<Integer, String>>();
		Iterator<Entry<Integer, GraphNode>> it =  hashIdNode.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, GraphNode> pairs = it.next();
			idTitle.add(new Pair(pairs.getKey(),pairs.getValue()));
		}
		return idTitle;		
	}

	private List<Integer> arrayToList(int[] arr) {
		List<Integer> larray = new ArrayList<Integer>();
		for (int val : arr)
			larray.add(val);
		return larray;
	}
	
	private void insertChildToParents(int[] parents, int child){
		for (int parent: parents){
			hashIdNode.get(parent).addChild(child);
		}
	}
	private void insertParentToChilds(int[] childs,int parent) {
		for (int child:childs){
			hashIdNode.get(child).addParent(parent);
		}
	}
}
