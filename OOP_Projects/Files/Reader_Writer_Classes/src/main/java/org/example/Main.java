package org.example;

import java.io.*;
// Alt + shift + (+||-) to change the font size
public class Main {
    public static void main(String[] args) throws IOException {
        /*
         *  FileWriter fw = new FileWriter("file_Writer.txt",true) ;
            fw.write("My name is Khaled Ekramy") ;
            fw.write(97);
            fw.write(String.valueOf(97));// will write the character that has the ASCII code 97 which is 'a'
            fw.close() ;
            System.out.println();
            File file = new File("file_Writer.txt") ;
            //////////////////////////////////////////
            FileReader fr = new FileReader(file) ;
            char arr[] = new char[(int)file.length()] ;
            fr.read(arr) ;
            System.out.println(arr);
            fr.close() ;
        */       
        /*
        Another way to write to a file is using the wrapper way :
        Writer writer = new OutputStreamWriter(new OutputStreamWriter("file_Writer.txt")) ; // called the wrapper way because Writer is the super for all write classes.
        weriter.write("Hello World") ;
        writer.close() ;
        writer.flush() ; // is an important line of code because you use multiple streams to write to a file and flush will help you to write make sure that the data is written to the file
         */
        /////////////////////////////////////
//        BufferedWriter bw = new BufferedWriter(new FileWriter("file_Writer.txt")) ; // If you want to prevent Overriding pass true to FileWriter constructor not BufferWriter because it doesn't receive any boolean funciton only Writer and int size
//        bw.write("AAAA");
//        bw.newLine();
//        bw.write("BBBB");
//        bw.newLine();
//        bw.write("CCCC");
//        bw.close();
//        File file3 = new File("file_Writer.txt");
//        FileReader FR = new FileReader(file3);
//        BufferedReader br = new BufferedReader(FR);
//        String str ;
//        str = br.readLine() ;
//        System.out.println(br.read()) ;
//        System.out.println(str+"1");
//        char[] by = new char[(int)file3.length()];
//        br.read(by);
//        System.out.println(by);
//
        File html = new File("Khaled2.png");
        html.createNewFile();
        File image = new File("Khaled.jpg");
        FileInputStream fes = new FileInputStream(image);
        FileOutputStream fos = new FileOutputStream(html) ;
        fos.write(fes.readAllBytes());
        fos.flush();
        fos.close();
        fes.close();
        String s = "\nKhaled Ekramy" ;

        
    }
}