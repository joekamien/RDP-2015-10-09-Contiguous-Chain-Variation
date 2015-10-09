
public class Point {
	private int x, y;
	
	public Point(int myX, int myY){
		x = myX;
		y = myY;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
	
	@Override
    public int hashCode() {
        return 31 * x + y;
    }
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
}
