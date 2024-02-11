package org.example;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.PrintWriter ;
import java.nio.charset.Charset;
import java.util.Scanner ;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*
        try {
            File file = new File("printWriter.txt") ;
            file.createNewFile() ;
            FileWriter fw = new FileWriter(file) ;
            PrintWriter pw = new PrintWriter(fw,true);
            pw.print("Hello world") ;
            pw.print("CCC") ;
            pw.print(true) ;
//            pw.flush();
        } catch(IOException e){
            e.printStackTrace();
        }
        */

        try{// Relate to Scanner Class.
            File fl = new File("printWriter.txt") ;
            Scanner sc = new Scanner(fl, Charset.forName("UTF-8") );
            sc.useDelimiter(" ") ;//
//            sc.useDelimiter("\\z") ;
//            System.out.println(sc.next());
//            sc.useDelimiter("\\D+") ;// to just read integers D+ means 1 or more.
            sc.useDelimiter(Pattern.compile(",")); // print each with each comma
            while(sc.hasNext()){
                System.out.println(sc.next());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}