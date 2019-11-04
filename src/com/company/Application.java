package com.company;


import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        DuplicateRemover dr = new DuplicateRemover();

        File dataFile = new File("problem1.txt");
        File outputFile = new File("unique_words.txt");
        boolean fileExists = outputFile.exists();

        if (fileExists == false){
            outputFile.createNewFile();
            boolean flag = outputFile.mkdir();
            System.out.println("Directory created? " + flag);
        }

        dr.remove(dataFile);
        dr.write(outputFile);
    }
}
