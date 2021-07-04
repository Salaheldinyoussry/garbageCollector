package garbageCollector;

import java.io.IOException;

public class testMandC {

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
//             
//            // Work with your 'file' object here
//        
	    try {
	      	String nheap="F:\\eclipseWorkspace\\garbageCollector\\tests\\test\\newHeapMC.csv";
		      String roots="F:\\eclipseWorkspace\\garbageCollector\\tests\\test\\root.txt";
		     	String heap="F:\\eclipseWorkspace\\garbageCollector\\tests\\test\\heap.csv";
		     String pointers="F:\\eclipseWorkspace\\garbageCollector\\tests\\test\\pointers.csv";
	    	
		MarkAndCompact mc =new MarkAndCompact(nheap,roots,heap,pointers);
		mc.collectGarabage();
	    }catch(Exception e) {
	    	System.out.println("the pathes of the files should be in this form : \" F:\\eclipseWorkspace\\garbageCollector\\tests\\test4\\roots.txt \"   note that includes the file name" );
	    	//e.printStackTrace();
	    }
		
		
	}
	
	
	
}
