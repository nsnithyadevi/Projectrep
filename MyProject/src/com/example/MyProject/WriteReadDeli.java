package com.example.MyProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

;

public class WriteReadDeli {

        public static void main(String[] args) {
            //Writing into delimited test file
            List<String> nameList = new ArrayList<>();
            nameList.addAll(Arrays.asList("testing", "checking"));
            try{
                FileWriter fw = new FileWriter("/Users/nithya/Documents/testing1.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter writer = new PrintWriter(bw);
                for (String name : nameList){
                    writer.write(name.concat("," ));
                }
                writer.close();
            } catch (IOException e){
                System.out.println("File not found.");
            }
            //Reading from delimited text file, here I considered the delimiter as comma
            try {
                Scanner read = new Scanner (new File("/Users/nithya/Documents/testing1.txt"));
                read.useDelimiter(",");
                while(read.hasNext())
                {
                    System.out.println(read.next());
                }
                read.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

