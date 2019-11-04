package com.company;


import java.io.File;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        DuplicateCounter dc = new DuplicateCounter();

        File dataFile = new File("problem2.txt");
        File outputFile = new File("unique_word_counts.txt");
        boolean fileExists = outputFile.exists();

        if (fileExists == false){
            outputFile.createNewFile();
            boolean flag = outputFile.mkdir();
            System.out.println("Directory created? " + flag);
        }

        dc.count(dataFile);
        dc.write(outputFile);
    }
}
