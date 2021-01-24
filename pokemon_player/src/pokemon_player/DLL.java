package pokemon_player;

public class DLL {
	Node front;
	int size;
	
	public DLL() {  // empty linked list to start with
		front = null;
		size = 0;
	}
	
	public void addFront(double data) {
		Node new_node = new Node(data);
		new_node.next = front;
		new_node.prev = null;
		if(front != null){
			front.prev = new_node;
		}
		front = new_node;
		size++;
	}
	
	public void addRear(double data) {
		Node new_node = new Node(data);
		Node last = front;
		new_node.next = null;
		if(front == null) {
			new_node.prev = null;
			front = new_node;
			return;
		}
		while (last.next!=null) {
			last = last.next;
		}
		last.next = new_node;
		new_node.prev = last;
		size++;
	}
	
	public void traverse(Node front) {
		
	}

	//Create DLL with stat modifiers
	public static Node stat_mods() {
		DLL stat_mods = new DLL();
		stat_mods.addFront(2/2);
		for(int i=3; i<=8; i++) {
			stat_mods.addFront((double)2/i);
			stat_mods.addRear((double)i/2);
		}
		Node ptr = stat_mods.front;
		while(ptr.data != 1.0) {
			ptr = ptr.next;
		}
		return ptr;
	}
}





