package GenericorderedArray;


public class UseOrderedArray {

	public static void main(String[] args) {
		OrderedArray o=new OrderedArray(4);
		
		System.out.print("Is list empty?");
		System.out.println(" "+o.isEmpty());
		
		o.insert(new Student("ali","ghaleb",10,'m'));
		o.insert(new Student("john","jordan",20,'f'));
		o.insert(new Student("sam","jones",1,'m'));
		o.insert(new Student("jones","john",2,'f'));
		o.list();
		
		System.out.println(o.search("ali"));
		System.out.println(o.search("sam"));
		System.out.println(o.search("moe"));
		
		System.out.println("Before Deleting:");
		o.list();
		System.out.println();
		
		o.delete(new Student("ali","ghaleb",2,'f'));
		o.list();
		System.out.println();

		System.out.print("Is list Full?");
		System.out.println(" "+o.isFull());

	}

}
