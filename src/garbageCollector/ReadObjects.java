package garbageCollector;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadObjects {
	public ArrayList<Integer> roots = new ArrayList<Integer>();  
	public ArrayList<Point> pointers= new ArrayList<Point>();
	String rootsPath;
	String heapPath;
	String pointersPath;
	public ReadObjects(String rootsP, String heapP, String pointersP) {
		// TODO Auto-generated constructor stub
   this.heapPath=heapP;
   this.pointersPath=pointersP;
   this.rootsPath=rootsP;
	}
	private void getPointers() throws FileNotFoundException{
		
		BufferedReader csvReader = new BufferedReader(new FileReader(pointersPath));
		String row;
		try {
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			   pointers.add(new Point(Integer.parseInt(data[0]),Integer.parseInt(data[1])));
			   
			    
			}
			
			csvReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void readRoots() throws FileNotFoundException{
		Scanner scanner = new Scanner(new File(rootsPath));
	
		while(scanner.hasNextInt())
		{
		     roots.add(  scanner.nextInt() );
		}
		
		
		
	}
	public ArrayList<Integer> [] getGraph()throws FileNotFoundException {
		getPointers();	
		readRoots();
		ArrayList<Integer> [] adj =new ArrayList[1000000];
		for(int i=0; i<1000000; i++) {
			adj[i]=new ArrayList<Integer>();
						
		}
		for(int i=0; i<pointers.size(); i++) {
			adj[pointers.get(i).x].add(pointers.get(i).y);
      }
		return adj;
		
		
		
		
	}
	
	
	public ArrayList<ArrayList<Integer>> getHeap() throws FileNotFoundException{
		
		ArrayList<ArrayList<Integer>> heap =new ArrayList<ArrayList<Integer>>();
		BufferedReader csvReader = new BufferedReader(new FileReader(heapPath));
		String row;
		try {
			while ((row = csvReader.readLine()) != null) {
			    String[] data = row.split(",");
			//    for(int i=0; i<data.length; i++) {
			  //  	System.out.print(data[i]+"  ");
			    //}
		    	//System.out.println("  ");

			 ArrayList<Integer>temp =new ArrayList<>();
			 temp.add(Integer.parseInt(data[0]));
			 temp.add(Integer.parseInt(data[1]));
			 temp.add(Integer.parseInt(data[2]));

			 heap.add((new ArrayList<Integer>(temp)));
			 
			   
		
			   
			}
			
			csvReader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return heap;
		
		
	}
	
	
	
}
