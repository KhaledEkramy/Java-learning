package org.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class Main {
    static void m1(int x) throws FileNotFoundException {
        if (x <= 0) {
            throw new MyException("The value must be greater than zero");//custom exception
        } else {
            System.out.println("Welcomed value");
        }

    }

    public static void main(String[] args) {
        // File file = new File("input.txt") ;
        // try (FileInputStream fis = new FileInputStream(file)){
        // } catch (Exception e) {
        //     System.out.println("Hello world");
        // }
        // finally{
        //     System.out.println("Hello Khaled");
        // }
        try {
            m1(0);// Because this is a checked Exception
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {// What I want you to know is the finally block run before throwing the exception.s
            System.out.println("Finally Block");
        }
    }
}