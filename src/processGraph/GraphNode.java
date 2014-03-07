package processGraph;

import java.util.List;

public class GraphNode {
	private int uid;
	private String title;
	private String description;
	private String actor;
	private int duration; 
	private int cost;
	private List<Integer> parents;
	private List<Integer> childs;

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public List<Integer> getParents() {
		return parents;
	}
	public void setParents(List<Integer> parents) {
		this.parents = parents;
	}
	public List<Integer> getChilds() {
		return childs;
	}
	public void setChilds(List<Integer> childs) {
		this.childs = childs;
	}
	public GraphNode(int uid, String title, String description, String actor,
			int duration, int cost, List<Integer> parents, List<Integer> childs) {
		setUid(uid);
		setTitle(title);
		setDescription(description);
		setActor(actor);
		setDuration(duration);
		setCost(cost);
		setParents(parents);
		setChilds(childs);
	}
	public void addChild(int child){
		this.childs.add(child);
	}
	public void addMultipleChilds(int[] childs){
		for (int child:childs) addChild(child);
	}
	public void addParent(int parent){
		this.parents.add(parent);
	}
	public void addMultipleParents(int[] parents){
		for (int parent:parents) addParent(parent);
	}
}
