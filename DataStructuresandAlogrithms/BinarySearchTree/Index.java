package BinarySearchTree;

//Binary Search Tree
public class Index 
{
	private IndexRecord top;
	
	public Index()
	{
		top = null; 
	}
	
	//Insert nodes into the tree
	public void insert(IndexRecord newTree)
	{
		IndexRecord prev=top;
		IndexRecord rover=top;
		boolean isleft=false;
		
		//If tree does not have top start at the top
		if(top == null)
		{
			top = newTree;
		}
		else
		{
			while(rover != null)
			{
				prev = rover;
				//check which side new node should be inserted 
				if(rover.getKey().compareTo(newTree.key)<0)
				{
					isleft = false;
					rover = rover.getRight();
				}
				else
				{
					isleft= true;
					rover = rover.getLeft();
				}
			}
			
			//Insert node here
			if(isleft)
			{
				prev.setLeft(newTree);
			}
			else
			{
				prev.setRight(newTree);
			}
		}
	
	}
	
	//find a node in a tree
	public int find(String s)
	{
		IndexRecord rover = top;
		while( rover != null )
		{
			if(rover.getKey().compareTo(s) == 0) break;
				
			if(rover.getKey().compareTo(s)<0)
			{
				rover = rover.getRight();
			}
			else
			{
				rover = rover.getLeft();
			}	
		}
		return(rover == null? -1: rover.getWhere());		
	}
	
	//Delete a node
	public boolean delete(String s)
	{
		IndexRecord parent = top;
		IndexRecord rover = top;
		boolean isleft = false;
		
		//Check which side node is on.
		while(rover.getKey().compareTo(s)!= 0 )
		{
			parent = rover;
			if(rover.getKey().compareTo(s)<0)
			{
				isleft=false;
				rover = rover.getRight();
			}
			else
			{
				isleft=true;
				rover = rover.getLeft();
			}	
		}
		
		//Delete node with no children
		if(rover.getLeft() == null && rover.getRight() == null)
		{
			if(rover == top)
				top = null;
			else if(isleft)
				parent.left = null;
			else 
				parent.right = null;
		}
		
		//Delete node with one right child
		else if(rover.getLeft() == null)
		{
			if(rover == top)
				top = top.getRight();
			else if(isleft)
				parent.left = rover.right;
			else
				parent.right = rover.right;
		}
		
		//Delete node with left child
		else if(rover.getRight() == null)
		{
			if(rover == top)
				top = top.left;
			else if(isleft)
				parent.left = rover.left;
			else
				parent.right = rover.left;
		}
		
		// Delete node with two children
		else
		{
			IndexRecord successor = getSuccessor(rover);
			if(rover == top)
				top = successor;
			else if(isleft)
				parent.left = successor;
			else
				parent.right = successor;
			
			successor.left = rover.left;
		}
		return true;
	}
	//A method to get the successor of a node if required.
	private IndexRecord getSuccessor(IndexRecord rover) {
		IndexRecord successorParent = rover;
		IndexRecord successor = rover;
		IndexRecord current = rover.getRight();
		
		while(current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		if(successor != rover.right)
		{
			successorParent.left = successor.right;
			successor.right = rover.right;
		}	
		return successor;
	}
	
	//Print out binary search tree.
	public void printIt(StudentRecord[] s, int choice)
	{
		IndexRecord rover = top;
		if(choice == 1)
		{
			printInorder(rover,s);
		}
		else if (choice ==0 )
		{
			printPostorder(rover,s);
		}
	}
	
	//Printing is done here from least to greatest value.
	private void printInorder(IndexRecord top2, StudentRecord[] s)
	{
		if(top2 != null)
		{
			printInorder(top2.getLeft(),s);
			System.out.println(s[top2.getWhere()]);
			printInorder(top2.getRight(),s);
		}
	}	
	
	//Printing is done here from greatest to least value.
	private void printPostorder(IndexRecord top1, StudentRecord[] s)
	{
		if(top1 != null)
		{
			printPostorder(top1.getRight(),s);
			System.out.println(s[top1.getWhere()]);
			printPostorder(top1.getLeft(),s);
		}
	}
}
