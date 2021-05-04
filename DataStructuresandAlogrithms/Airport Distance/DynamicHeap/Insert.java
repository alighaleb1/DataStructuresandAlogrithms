package DynamicHeap;

public class Insert {

	public static void main(String[] args) 
	{
		Heap h = new Heap(10);
		h.push(10);
		h.push(20);
		h.push(30);
		h.push(19);
		h.push(28);
		h.push(45);
		h.push(13);
		h.push(27);
		h.push(35);
		h.push(15);
		
		h.pop();
		h.displayHeap();
		h.pop();
		h.displayHeap();

	}

}
