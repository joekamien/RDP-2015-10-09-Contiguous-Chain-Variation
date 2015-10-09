import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int maxY = scanner.nextInt();
		int maxX = scanner.nextInt();
		scanner.nextLine();
		
		Graph g = new Graph(maxX, maxY);
		
		for(int y = 0; y < maxY; y++){
			String line = scanner.nextLine();
			for(int x = 0; x < maxX; x++){
				if(line.charAt(x) == 'x' || line.charAt(x) == 'X'){
					g.addNode(new Point(x,y));
				}
			}
		}
		
		scanner.close();
		
		
	}

}
