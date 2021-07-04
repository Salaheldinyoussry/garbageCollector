package garbageCollector;

import java.io.FileNotFoundException;
import java.io.IOException;



public class testCopy {

	public static void main(String[] args) throws IOException {
//	    if(args.length !=4 ) {
//	    	System.out.println("enter the 4 arguments proberly !!");
//	    return;
//	    }
//             String nheap=args[0];
//             String roots=args[1];
//             String heap=args[2];
//             String pointers=args[3];
//             
             
            // Work with your 'file' object here
        
	    try {
	    	String nheap="F:\\eclipseWorkspace\\garbageCollector\\tests\\test3\\newHeap.csv";
	      String roots="F:\\eclipseWorkspace\\garbageCollector\\tests\\test3\\roots.txt";
	     	String heap="F:\\eclipseWorkspace\\garbageCollector\\tests\\test3\\heap.csv";
	     String pointers="F:\\eclipseWorkspace\\garbageCollector\\tests\\test3\\pointers.csv";	
	    	
		Copy mc =new Copy(nheap,roots,heap,pointers);
		mc.collect();
	    }catch(Exception e) {
	    	System.out.println("the pathes of the files should be in this form : \" F:\\eclipseWorkspace\\garbageCollector\\tests\\test4\\roots.txt \"   note that includes the file name" );
	    	//e.printStackTrace();
	    }
	  // public MarkAndCompact(String newHeapP,String rootsP ,String heapP,String pointersP ) throws FileNotFoundException {
	}
}
