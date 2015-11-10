import java.util.Stack;


public class MotorInterface {
	
	int currentDirection; // describes weather the robot is facing East(0), North(1), South(2) or West(3)
	int currX;
	int currY;
	OurMove om;
	int distance;
	
	public MotorInterface(int currentDirection, int currX, int currY){
		this.currentDirection = currentDirection;
		this.currX = currX;
		this.currY = currY;
	}
	
	public void moveEast(){
		switch (currentDirection) {
			case 0:	// currently facing east
				//TODO:drive one node forward
				om.forward(distance);
				break;
			case 1:	// currently facing north
				//TODO:turn right 90 then one Node forward
				om.rotateRight(90);
				om.forward(distance);
				break;
			case 2:	// currently facing south
				//TODO:turn left 90 then one Node forward
				om.rotateLeft(90);
				om.forward(distance);
				break;
			case 3:	// currently facing west
				//TODO:turn 180 then one Node forward
				om.rotateLeft(180);
				om.forward(distance);
				break;
	
			default:
				System.out.println("ERROR: currentDirection not 0,1,2 or 3!");
				break;
		}
		currentDirection = 0;
		currX += 1;
	}
	
	public void moveNorth(){
		switch (currentDirection) {
			case 0:	// currently facing east
				//TODO:turn 90 left then one Node forward
				om.rotateLeft(90);
				om.forward(distance);
				break;
			case 1:	// currently facing north
				//TODO:one node forward
				om.forward(distance);
				break;
			case 2:	// currently facing south
				//TODO:turn 180 then one node forward
				om.rotateLeft(180);
				om.forward(distance);
				break;
			case 3:	// currently facing west
				//TODO:turn 90 right then one node forward
				om.rotateRight(90);
				om.forward(distance);
				break;
	
			default:
				System.out.println("ERROR: currentDirection not 0,1,2 or 3!");
				break;
		}
		currentDirection = 1;
		currY += 1;
	}
	
	public void moveSouth(){
		switch (currentDirection) {
			case 0:	// currently facing east
				//TODO:turn 90 right then one node forward
				om.rotateRight(90);
				om.forward(distance);
				break;
			case 1:	// currently facing north
				//TODO:turn 180 then one node forward
				om.rotateLeft(180);
				om.forward(distance);
				break;
			case 2:	// currently facing south
				//TODO:one node forward
				om.forward(distance);
				break;
			case 3:	// currently facing west
				//TODO:turn 90 left then one node forward
				break;
	
			default:
				System.out.println("ERROR: currentDirection not 0,1,2 or 3!");
				break;
		}
		currentDirection = 2;
		currY -= 1;
	}
	
	public void moveWest(){

		switch (currentDirection) {
			case 0:	// currently facing east
				//TODO:turn 180 then one node forward
				break;
			case 1:	// currently facing north
				//TODO:turn 90 left then one node forward
				break;
			case 2:	// currently facing south
				//TODO:turn 90 right then one node forward
				break;
			case 3:	// currently facing west
				//TODO:one node forward
				om.rotateLeft(90);
				om.forward(distance);
				break;
	
			default:
				System.out.println("ERROR: currentDirection not 0,1,2 or 3!");
				break;
		}
		currentDirection = 3;
		currX -= 1;
	}
	
	public void drivePath(Stack<Node> s){
		while(s.size() != 0){
			Node currNode = s.pop();
			switch (currX - currNode.getX()) {
				case -1:
					moveWest();
					break;
				case 0:
					break;
				case 1:
					moveEast();
					break;
				default:
					System.out.println("ERROR: Invalid Node - distance too high:");
					System.out.println("currX,currY = " + currX + "," + currY);
					System.out.println("nodeX,nodeY = " + currNode.getX() + "," + currNode.getY());
					break;
			}
			
			
			switch (currY - currNode.getY()) {
				case -1:
					//TODO ADD DELAY RIGHT HERE IF WE HAVE TO GO DIAGONAL
					moveSouth();
					break;
				case 0:
					break;
				case 1:
					//TODO ADD DELAY RIGHT HERE IF WE HAVE TO GO DIAGONAL
					moveNorth();
					break;
				default:
					System.out.println("ERROR: Invalid Node - distance too high:");
					System.out.println("currX,currY = " + currX + "," + currY);
					System.out.println("nodeX,nodeY = " + currNode.getX() + "," + currNode.getY());
					break;
			}
		}
	}
}
