/**
 * class Map
 * contains a twodimensional array of integers which can be accessed via getters&setters
 * contains dimX and dimY which are the size of the array
 * currently the x and y coordinates are somewhat confusing.
 * [0,0] is in the top left
 * adding to the y-component moves the coordinate to the right
 * adding to the x-component moves the coordinate to the ground
 * 
 * @author Christoph
 *
 */
public class Map {
	private int[][] map;
	int dimX;
	int dimY;

	public Map(int dimX, int dimY){
		map = new int[dimX][dimY];
		for(int i = 0; i<dimX; i++){
			for(int j = 0; j<dimY; j++){
				map[i][j]=0;
			}
		}
		this.dimX = dimX;
		this.dimY = dimY;
	}
	
	
	public int get(int x, int y){
		return map[x][y];
	}
	public void set(int x, int y, int value){
		map[x][y] = value;
	}
	
	public boolean exists(int x, int y){
		if((x >=0 && y>= 0) && (x<map.length && y<map[0].length))
			return true;
		else
			return false;
	}
	public boolean isObstacle(int x, int y){
		if(map[x][y]==1)
			return true;
		else
			return false;
	}
	
	public String toString(){
		String s = "";
		for(int i = 0; i < dimX; i++){
			for(int j = 0; j < dimY; j++){
				s += map[i][j];
				s += " ";
			}
			s+= "\n";
		}
		return s;
	}
}
