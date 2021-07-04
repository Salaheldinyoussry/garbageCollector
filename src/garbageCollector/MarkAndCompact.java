package garbageCollector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MarkAndCompact {
   ReadObjects ro ;
   ArrayList<Integer> [] adj;
   ArrayList<Integer> roots;
   String newheapP;
   boolean[] vis =new boolean[1000000];
   public MarkAndCompact(String newHeapP,String rootsP ,String heapP,String pointersP ) throws FileNotFoundException {
	 ro=new ReadObjects(rootsP,heapP,pointersP);
	 adj=ro.getGraph();
    // System.out.println(adj[111111].size());

	 roots=ro.roots;
	 this.newheapP=newHeapP;
	 
 }
   void dfs(int n) {
	     //System.out.println(n);

	   vis[n]=true;
	   for(int i=0; i<adj[n].size(); i++) {
		   if(!vis[adj[n].get(i)]) {
			  dfs(adj[n].get(i));
		   }
	   }
	   
   }
 public void collectGarabage() throws IOException {
	 for(int i=0; i<1000000; i++) {
		 vis[i]=false;
	 }
	 for(int i=0; i<roots.size(); i++) {
		 if(!vis[roots.get(i)]) {
			 dfs(roots.get(i));
		 }
	 }
	 ArrayList<ArrayList<Integer>> heap=ro.getHeap();
	 int nextFree =heap.get(0).get(1);
	 for(int i=0; i<heap.size(); i++) {
		 if(!vis[heap.get(i).get(0)]) {
			 heap.get(i).set(0, -1);
		 }
		 else {
			 int offset =heap.get(i).get(1)-nextFree;
			 heap.get(i).set(1, nextFree);
			 heap.get(i).set(2,heap.get(i).get(2)-offset);
			 nextFree=heap.get(i).get(2)+1;
		 }
	 }
	 
//	 FileWriter csvWriter1 = new FileWriter(newheapP+"\\new-heap.csv");
//
//csvWriter1.flush();
//csvWriter1.close();
// 
//	 
//	 FileWriter csvWriter = new FileWriter(newheapP+"\\new-heap.csv");
//	  StringBuilder builder = new StringBuilder();
//
//	 for (int i=0; i<heap.size(); i++) {
//		    if(heap.get(i).get(0)!=-1) { 
//
//			    	builder.append(""+heap.get(i).get(0)+","+heap.get(i).get(1)+","+heap.get(i).get(2));
//			   builder.append("\n");		   
//			   }
//csvWriter.append(builder.toString());		    
//
//csvWriter.flush();
//csvWriter.close();
// 
// 
// }
 
 
     PrintWriter pw = null;
     try {
         pw = new PrintWriter(new File(newheapP));
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     }
     StringBuilder builder = new StringBuilder();

     for (int i=0; i<heap.size(); i++) {
   
		    if(heap.get(i).get(0)!=-1) { 

		    	builder.append(""+heap.get(i).get(0)+","+heap.get(i).get(1)+","+heap.get(i).get(2));
		   builder.append("\r\n");
		   

 }}
 

 pw.write(builder.toString());

pw.close();
 
 
 
 }



}
