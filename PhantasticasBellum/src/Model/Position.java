package Model;

public class Position {
	private int x = 0;
	private int y = 0;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Position(){
		this(-1, -1);
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
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Object obj){
		if (obj == this){
			return true;
		}
		if (!(obj instanceof Position)){
			return false;
		}
		Position Temp = (Position) obj;
		return (this.getX() == Temp.getX() && this.getY() == Temp.getY());
	}
}
