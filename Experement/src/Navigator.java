import java.util.LinkedList;
import java.util.Stack;

/**
 * class Navigator
 * this class contains the A*-Algorithm within the "navigateTo(x,y)" function
 * and everything that belongs to A*.
 * 
 * @author Christoph
 *
 */
public class Navigator {
	
	LinkedList<Node> open = new LinkedList<Node>();
	LinkedList<Node> closed = new LinkedList<Node>();
	Stack<Node> path = new Stack<Node>();	// the final path which will be handed to the "robot"
	Node startNode;
	Map map;
	
	public Navigator(int currX, int currY, Map map){
		startNode = new Node(currX,currY);
		this.map = map;
	}
	
	public void setStartNode(int currX, int currY){
		startNode = new Node(currX,currY);		
	}
	public Stack<Node> getPath(){
		return path;
	}
	
	/**
	 * Method navigateTo(int x, int y) changes the stack(of Nodes) path which can be accessed
	 * via getPath() to a number of coordinates which describe the way to the target.
	 * The top element on the stack describes the first coordinate to travel to in 
	 * order to reach the target on the most efficient way, the second element describes
	 * the second coordinate and so on.
	 * @param x target x-coordinate on the map
	 * @param y target y-coordinate on the map
	 */
	public void navigateTo(int x, int y){
		open.clear();
		closed.clear();
		path.clear();
		open.add(startNode);
		
		while(!open.isEmpty()){
			float lowestF = 100000f;		// we want to find the lowest f in open
			Node q;
			int lowestFIndex = 0;
			for(int i = 0; i<open.size(); i++){
				if(open.get(i).getF() < lowestF){
					lowestF = open.get(i).getF();
					lowestFIndex = i;
				}
			}
			q = open.remove(lowestFIndex); // we found it
			
			//for each successor of q
			for(int i = -1; i<=1; i++){
				for(int j = -1; j<=1; j++){
					if(i==0 && j==0)	// we don't count our current node, just the 8 surrounding nodes
						continue;
					
					//test if successor is part of the map and not an obstacle
					if( ( map.exists((q.getX()+i),(q.getY()+j)) ) && ( !map.isObstacle((q.getX()+i),(q.getY()+j)) ) ) {
						Node successorOfQ = new Node(q.getX()+i, q.getY()+j);	// generate successor
						successorOfQ.setParent(q);
						
						//if successor is goal, finish searching, create path
						if(successorOfQ.getX()==x && successorOfQ.getY()==y){
							System.out.println("...creating Stack...");
							Node tmpN = successorOfQ;
							path.push(successorOfQ);
							
							tmpN = tmpN.getParent();
							
							while(tmpN.getParent()!= null){
								path.push(tmpN);
								tmpN = tmpN.getParent();
							}
							return; // we're done here
						}
						
						successorOfQ.setG(q.getG() + successorOfQ.distanceTo(q));	// distance from q to successor
						Node goal = new Node(x,y);
						successorOfQ.setH(successorOfQ.distanceTo(goal));	// distance from goal to successor
						successorOfQ.setF(successorOfQ.getG() + successorOfQ.getH());
						
						
						boolean skipThisSuccessor = false;
						for(int k = 0; k<open.size(); k++){
							if(open.get(k).getX() == successorOfQ.getX() && open.get(k).getY() == successorOfQ.getY()){	// successor already in open
								if(open.get(k).getF() <= successorOfQ.getF()){
									skipThisSuccessor = true;
								}
							}
						}

						for(int k = 0; k<closed.size(); k++){
							if(closed.get(k).getX() == successorOfQ.getX() && closed.get(k).getY() == successorOfQ.getY()){	// successor already in open
								if(closed.get(k).getF() <= successorOfQ.getF()){
									skipThisSuccessor = true;
								}
							}
						}
						if(!skipThisSuccessor){
							open.add(successorOfQ);
						}
					}
				}
			}
			
			closed.push(q);
			
		}//end of while
	System.out.println("ERROR: COULD NOT FIND PATH");
	}
}