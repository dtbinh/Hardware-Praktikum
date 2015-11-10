
public class Node {
	private Node parent;
	private int x, y;
	private float f, g, h;
	
	
	public Node(int x, int y){
		this.x = x;
		this.y = y;
	}	
	
	//returns the manhattan distance
	public float distanceTo(Node n){
		float distance = 0;
		distance += Math.abs(x - n.getX());
		distance += Math.abs(y - n.getY());
		return distance;
	}
	
	public String toString(){
		String s = "";
		s += x + " " + y;
		return s;
	}
	
	//
	//from here on only getters&setters
	//
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public float getF() {
		return f;
	}
	public void setF(float f) {
		this.f = f;
	}
	public float getG() {
		return g;
	}
	public void setG(float g) {
		this.g = g;
	}
	public float getH() {
		return h;
	}
	public void setH(float h) {
		this.h = h;
	}

}
