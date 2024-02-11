package org.example;
import java.awt.Desktop;
import java.io.File ;
import java.io.FileInputStream ;
import java.io.FileOutputStream  ;
import java.io.FileNotFoundException ;
import java.io.IOException ;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        File file = new File("target\\newFile.txt") ;
//        file.createNewFile() ;
//        FileOutputStream fos = new FileOutputStream(file) ;
//        String str = "My " ;
//        fos.write(str.getBytes()) ;
//        System.out.println(file.length());
//        long x = file.lastModified() ; // returns last modified time in mille seconds.

/////////////////////////////////////////////////////////////////////////////////////////////////
//        File file = new File("Khaled Ekramy"+".txt") ;
//        File newFile = new File("new Khaled Ekramy.txt") ;
//        System.out.println(newFile.getPath() + " " + newFile.getName());
//        openFileInEditor(newFile.getPath());
//        file.renameTo(newFile) ;
/////////////////////////////////////////////////////////////////////////////////////////////////
//        File folder = new File("MakingFolder2") ;
//        folder.mkdirs() ;
//        File deletingFolder = new File("MakingFolder") ;
//        String[] dirLists = deletingFolder.list() ;
//
//        for(String s : dirLists){
//            System.out.println(s);
//            File temp = new File(deletingFolder.getPath()+'/'+s) ;
//            temp.delete() ;
//        }
//        deletingFolder.delete() ;
//
//        File f2 = new File(folder,"folder2") ;
//        f2.mkdir() ;


        // The following app helps you to convert a vtt file to a txt file.
        File testFile = new File("testFile.vtt");
        FileInputStream fis = new FileInputStream(testFile);
        byte bufferArr[] = new byte[(int)testFile.length()];
        fis.read(bufferArr) ;
        String str = new String(bufferArr) ;
        File outTestFile = new File("outTestFile.txt") ;
        FileOutputStream fos = new FileOutputStream(outTestFile) ;
        fos.write(str.getBytes()) ;
    }
    private static void openFileInEditor(String filePath) {
        try {
            // Check if Desktop is supported on the current platform
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Check if the file exists
                File file = new File(filePath);
                if (file.exists()) {
                    // Open the file for editing
                    desktop.edit(file);
                } else {
                    System.out.println("File does not exist: " + filePath);
                }
            } else {
                System.out.println("Desktop is not supported on this platform");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}