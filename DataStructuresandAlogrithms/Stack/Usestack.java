package Stack;


public class Usestack {
	public static void main(String[] args) {
		Stack myStack=new Stack(15);
		myStack.push(23);
		myStack.push(33);
		myStack.push(45);
		
		//myStack.pop();
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
       System.out.println(myStack.pop());

         int j;
         for(j=0; j<100;j++)
	      if (!myStack.isFull())
	       myStack.push(j+50);
          System.out.println("Don't blow your stack");
          while(!myStack.isEmpty())
        	  System.out.println(myStack.pop());


	}
}