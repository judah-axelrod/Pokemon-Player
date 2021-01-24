package pokemon_player;

public class Node {
	public double data;
	public Node prev;
	public Node next;
	public Node(double data){
		this.data = data;
	}

	public String toString() {
		return String.valueOf(data);
	}
}