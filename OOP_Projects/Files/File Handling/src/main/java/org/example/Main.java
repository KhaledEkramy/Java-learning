package org.example;

import java.io.File ;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException , IOException{
        // Good start with streams
//        File obj = new File("myFile.txt") ; // File object
//        FileInputStream fis = new FileInputStream(obj) ; // Initialize stream for reading
//        byte arr[] = new byte[(int)obj.length()] ;
//        fis.read(arr) ;
//        String fileString = new String(arr) ;
//        FileOutputStream fos = new FileOutputStream("output.txt") ;
//        fos.write(arr) ;
//        System.out.println(fos);
//        fos.close() ;

///////////////////////////////////////////////////////////////////
        /*
        File obj = new File("logo.jpg") ;
        FileOutputStream fos = new FileOutputStream("outputLogo.jpg") ;
        FileInputStream fis = new FileInputStream(obj) ;
        fos.write(fis.readAllBytes()) ;
        fos.close() ;

        */


        // This is the way to copy a file using streams and in the same way not Overriding the old file but appending the new data to the old one
        String fileName = "khaled" ;
        File inputFile = new File("myFile.txt") ;
        File outputFile = new File("myOutputFile.txt") ;
        FileInputStream fis = new FileInputStream(inputFile) ;
        FileOutputStream fos = new FileOutputStream(outputFile,true) ;
        // A good way to copy a file data with Arabic characters :
        String str = new String(fis.readAllBytes());
        fos.write(str.getBytes("UTF-8"));
        fos.flush(); // Just to be safe
        fos.close(); // Just to be safe
    }
}