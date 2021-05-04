/*
 * 	Ali Ghaleb
 * 	12/7/2020
 * 	Project 3 
 * 	COSC 314
 */


package COSC314;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Project3 {

	public static void main(String[] args) 
	{
		//Enter Airports through txt file;
		File file = new File("airport_codes.txt"); //airport names file
		File file2 = new File("distance_matrix.txt"); //airport matrixs
		//Needed arrays
		String[] airports = new String[8]; 
		String [][] airportDistance = new String[airports.length][airports.length];
		int[][] in = new int[airports.length][airports.length];
		//needed Scanners
		Scanner input;
		Scanner input2;
		int r =0;//row
		
		try
		{
			//Airports
			input = new Scanner(file);
			int i=0;
			
			//Entering airport names to String array
			while(input.hasNextLine())
			{
				String split= input.nextLine();
				airports[i] = split;
				i++;
			}
			
			//Airport distances
			input2 = new Scanner(file2);
			String num = " ";
			
			//Entering airport matrix to String array
			while(input2.hasNextLine())
			{
					String line = input2.nextLine();
					String[] distance = line.split(" ");
					for(int c=0;c<8 ; c++)
					{
						num  = distance[c];
						enterData(airportDistance, in, num,c,r);
					}
					r++;
			}		
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		int distancegetter = 1;
		while(distancegetter == 1)
		{
			System.out.println("\n");
			System.out.println("Airports you can get "
					+ "the shorest directions for:");
		
			System.out.println();
			for(int i=0; i< airports.length; i++)
			{
				System.out.print(airports[i]+"\n");
			}
		
			System.out.println();
			Scanner scan = new  Scanner(System.in);
			System.out.println();
			System.out.println("Please Enter The following Information In The order Asked! ");
			System.out.println();
			System.out.print("Starting Airport: ");
			String	startvertex = scan.next();
			System.out.print("\nEnding Airport: ");
			String endvertex = scan.next();
			System.out.println();
		
			//DijkstraShortestPath
			dijkstraShortestPath(startvertex, endvertex, airports, in);	
			System.out.println();
			System.out.println("Press 0 To Exit or 1 to get more directions");
			distancegetter = scan.nextInt();
		}
	}

	//Enter Distance data into array.
	private static void enterData(String[][] airportDistance, int[][] in, String num, int c, int r) 
	{
		airportDistance[r][c] = num;
		int index = Integer.parseInt(num);
		in[r][c] = index;
	}

	//DikstraShorestPath to get shortest mile distance and path
	private static void dijkstraShortestPath(String startvertex, String endvertex, String[] airports, int[][] airportDistance)
	{
		LinkedList d = new LinkedList(); // Implelemented Linked List for output
		ArrayList<String> airportS = new ArrayList();//airport names
		ArrayList<String> unvisteD = new ArrayList(); // unvisted vertixs
		HashMap<String, String[]> indexes = new HashMap(); //matrix data
		int length=0; //loop counter.
		int distance=0;  // path distance.
		//insert data into list and hashmap.
		while(length < airports.length)
		{
			airportS.add(airports[length]);
			unvisteD.add(airports[length]);
			length++;
		}	
		length = 0;
		while(length<airports.length)
		{
			indexes.put(unvisteD.get(length), new String[]{"25000", null});
			length++;
		}
		indexes.replace(startvertex, new String[]{"0", null}); 
		String vertixesinuse = startvertex;
		int eweighT =0;
		
	while(!unvisteD.isEmpty())// end while loop when arraylist is empty.
		{
			//remove first visted vertices
			int tempDistance=0; 
			boolean checker;
			unvisteD.remove(vertixesinuse); // Remove visted vertixes
			String adJ = " ";
			int location = airportS.indexOf(vertixesinuse); //index 
			for(int j =0; j<airports.length; j++)
			{
				eweighT = airportDistance[location][j]; //get weight
				tempDistance = Integer.valueOf(indexes.get(vertixesinuse)[0]); //store distance
				if(eweighT != 0 && eweighT != 25000) //0 and infinity
				{
					adJ = airportS.get(j);
					distance = tempDistance+eweighT;
					int checkweight = Integer.valueOf(indexes.get(adJ)[0]); //weight
					if(distance < checkweight)
					{
						indexes.replace(adJ, new String[] { String.valueOf(distance), vertixesinuse }); 
					}
				}
			}
			int empty = unvisteD.size(); //Check airport list if empty.
			if(empty == 0) 
			{
				checker = true;
			}
			else
			{
				String leastmilesv = unvisteD.get(0);
				int i;
				for(i=0; i<unvisteD.size();i++)
				{
					int unvistedD = Integer.valueOf(indexes.get(unvisteD.get(i)) [0]);
					int leastmilesD = Integer.valueOf(indexes.get(leastmilesv)[0]);
					if(unvistedD < leastmilesD) //check miles.
					{
						leastmilesv = unvisteD.get(i);
					}
				}
				vertixesinuse = leastmilesv; 
			}
		}
		
	//Using implemented LinkedList to output stored information.
		LinkedList p = new LinkedList();
		String pred = indexes.get(endvertex)[1];
		String path = endvertex;
		while(pred != (null))
		{
			path = pred+"  "+path;
			pred = indexes.get(pred)[1];
			if(pred == null)
			{
				p.insertPath(new Node("Shorest Path From "+startvertex+
						" to "+endvertex+" |"+path+"|"+"\n\nThe Shorest Distance From "
						+startvertex+" to "+endvertex+" is "+indexes.get(endvertex)[0]+" Miles."));
			}
		}
		//Get output
		p.print();
	}
}

//Test Cases
/*
___________________________________________________________________________________________
Airports you can get the shorest directions for:

HNL
LAX
SFO
ORD
DFW
LGA
PVD
MIA


Please Enter The following Information In The order Asked! 

Starting Airport: HNL

Ending Airport: PVD

Shorest Path From HNL to PVD |HNL  LAX  ORD  PVD|

The Shorest Distance From HNL to PVD is 5147 Miles. 

Press 0 To Exit or 1 to get more directions
1

___________________________________________________________________________________________
Airports you can get the shorest directions for:

HNL
LAX
SFO
ORD
DFW
LGA
PVD
MIA


Please Enter The following Information In The order Asked! 

Starting Airport: SFO

Ending Airport: MIA

Shorest Path From SFO to MIA |SFO  LAX  DFW  MIA|

The Shorest Distance From SFO to MIA is 2690 Miles. 

Press 0 To Exit or 1 to get more directions
1

__________________________________________________________________________________________
Airports you can get the shorest directions for:

HNL
LAX
SFO
ORD
DFW
LGA
PVD
MIA


Please Enter The following Information In The order Asked! 

Starting Airport: LAX

Ending Airport: LGA

Shorest Path From LAX to LGA |LAX  DFW  LGA|

The Shorest Distance From LAX to LGA is 2620 Miles. 

Press 0 To Exit or 1 to get more directions
1

__________________________________________________________________________________________
Airports you can get the shorest directions for:

HNL
LAX
SFO
ORD
DFW
LGA
PVD
MIA


Please Enter The following Information In The order Asked! 

Starting Airport: ORD

Ending Airport: PVD

Shorest Path From ORD to PVD |ORD  PVD|

The Shorest Distance From ORD to PVD is 849 Miles. 

Press 0 To Exit or 1 to get more directions
1
___________________________________________________________________________________________

Airports you can get the shorest directions for:

HNL
LAX
SFO
ORD
DFW
LGA
PVD
MIA


Please Enter The following Information In The order Asked! 

Starting Airport: DFW

Ending Airport: MIA

Shorest Path From DFW to MIA |DFW  MIA|

The Shorest Distance From DFW to MIA is 1120 Miles. 

Press 0 To Exit or 1 to get more directions
1

__________________________________________________________________________________________
Airports you can get the shorest directions for:

HNL
LAX
SFO
ORD
DFW
LGA
PVD
MIA


Please Enter The following Information In The order Asked! 

Starting Airport: ORD

Ending Airport: LGA

Shorest Path From ORD to LGA |ORD  PVD  LGA|

The Shorest Distance From ORD to LGA is 991 Miles. 

Press 0 To Exit or 1 to get more directions
1

____________________________________________________________________________________________
Airports you can get the shorest directions for:

HNL
LAX
SFO
ORD
DFW
LGA
PVD
MIA


Please Enter The following Information In The order Asked! 

Starting Airport: SFO

Ending Airport: MIA

Shorest Path From SFO to MIA |SFO  LAX  DFW  MIA|

The Shorest Distance From SFO to MIA is 2690 Miles. 

Press 0 To Exit or 1 to get more directions
0
*/
