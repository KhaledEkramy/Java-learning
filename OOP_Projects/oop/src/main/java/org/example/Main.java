package org.example;
import java.util.Scanner;
import java.io.* ;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            File file = new File("input.txt") ;
            BufferedReader reader = new BufferedReader(new FileReader(file)) ;
            File outputFile = new File("output.txt") ;
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line = reader.readLine();
            while(line != null){
                writer.write(line) ;
                writer.newLine();
                line = reader.readLine();
            }
            writer.flush();
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
            System.err.println("Error "+e.getMessage() );
        }
    }
}