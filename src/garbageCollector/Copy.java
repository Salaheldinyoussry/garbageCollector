package garbageCollector;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


public class Copy {
	////////////
	static int toAddress=100; //(+ last address of in current heap);
	
	
	///////////////
	   ReadObjects ro ;
	   ArrayList<Integer> [] adj;
	   ArrayList<Integer> roots;
	   String newheapP;
	   boolean[] vis =new boolean[1000000];
	   public Copy(String newHeapP,String rootsP ,String heapP,String pointersP ) throws FileNotFoundException {
		 ro=new ReadObjects(rootsP,heapP,pointersP);
		 adj=ro.getGraph();
	    // System.out.println(adj[111111].size());

		 roots=ro.roots;
		 this.newheapP=newHeapP;
		 
	 }
	   
	  public void collect() throws FileNotFoundException{
		  for(int i=0; i<1000000; i++) {
				 vis[i]=false;
			 }
		  ArrayList<ArrayList<Integer>> nheap=new ArrayList<ArrayList<Integer>>();
		     
		     HashMap<Integer, Point> map = new HashMap<>();
			 ArrayList<ArrayList<Integer>> heap=ro.getHeap();
		    
		      int lastaddress=0;
		     for(int i =0; i<heap.size(); i++) {
		    	 map.put(heap.get(i).get(0), new Point(heap.get(i).get(1),heap.get(i).get(2)));
		    	 if(heap.get(i).get(2)>lastaddress){
		    		 lastaddress=heap.get(i).get(2);
		    	 }
		     }
		     
		     int currentAvailableAddress=lastaddress+toAddress;
		     for(int i=0; i<roots.size(); i++) {
		    	ArrayList<Integer> temp =new ArrayList<>();
		    	temp.add(roots.get(i));
		    	int offset=map.get(roots.get(i)).y-map.get(roots.get(i)).x;
		    	temp.add(currentAvailableAddress);
		    	temp.add(currentAvailableAddress+offset);
		    	currentAvailableAddress+=(offset+1);
		    	 
		    	 nheap.add(temp);
		    	 vis[roots.get(i)]=true;
		     }
		     int i=0;
		     while(i<nheap.size()) {
		    	 for(int j=0; j<adj[nheap.get(i).get(0)].size(); j++){
		    		if(!vis[adj[nheap.get(i).get(0)].get(j)]) {
		    		 ArrayList<Integer> temp =new ArrayList<>();
				    	temp.add(adj[nheap.get(i).get(0)].get(j));
				    	int offset=map.get(adj[nheap.get(i).get(0)].get(j)).y-map.get(adj[nheap.get(i).get(0)].get(j)).x;
				    	temp.add(currentAvailableAddress);
				    	temp.add(currentAvailableAddress+offset);
				    	currentAvailableAddress+=(offset+1);
				    	 nheap.add(temp);
				    	 vis[adj[nheap.get(i).get(0)].get(j)]=true;

		    	 }}
		    	 i++;
		    	 
		     }
		     
		     PrintWriter pw = null;
		     try {
		         pw = new PrintWriter(new File(newheapP));
		     } catch (FileNotFoundException e) {
		         e.printStackTrace();
		     }
		     StringBuilder builder = new StringBuilder();

		     for (int i1=0; i1<nheap.size(); i1++) {
		   

				    	builder.append(""+nheap.get(i1).get(0)+","+nheap.get(i1).get(1)+","+nheap.get(i1).get(2));
				   builder.append("\r\n");
				   

		 }   
		 

		 pw.write(builder.toString());

		pw.close();
		 
		     
		     
		     
	  }
	   
	

}
