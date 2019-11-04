package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class DuplicateCounter {
    String[] uniqueWords = new String[100];
    int[] wordCounter = new int[100];
    int uniqueCount = 0;

    public void count(File dataFile) throws IOException {
        Arrays.fill(uniqueWords, " ");
        Arrays.fill(wordCounter, 0);
        String tempWord;
        int i = 0, j;
        boolean repeat;

        FileInputStream fileByteStream = null;
        Scanner inFS = null;

        fileByteStream = new FileInputStream(dataFile); //inputFile dataFile
        inFS = new Scanner(fileByteStream);

        while(inFS.hasNext()) {
            repeat = false;
            tempWord= inFS.next();
            for(j = 0; j < uniqueCount; j++) {
                if((tempWord.compareTo(uniqueWords[j])) == 0) {
                    wordCounter[j]++;
                    repeat = true;
                }
            }
            if(repeat == false) {
                uniqueWords[uniqueCount] = tempWord;
                wordCounter[uniqueCount] = 1;
                uniqueCount++;
            }
        }
        fileByteStream.close();
    }

    public void write(File outputFile) throws IOException {
        int i;

        FileOutputStream fileByteStream = new FileOutputStream(outputFile);
        PrintWriter outFS = new PrintWriter(fileByteStream);

        for(i = 0; i < uniqueCount; i++)
            outFS.println(uniqueWords[i] + ": " + wordCounter[i]);
        outFS.flush();
        fileByteStream.close();
    }

}
