package com.vv.java8.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by vasudvis on 2/19/2017.
 */
public class TestCommand {

    public static void main(String[] args) throws IOException {
        //printDiff("C:\\WebConsole.war","C:\\Users\\vasudvis\\sdm\\finl\\platform\\adm-suite\\webConsole\\DBArcMC\\target\\WebConsole-1.0-SNAPSHOT.war");
        printDiff("C:\\Users\\vasudvis\\sdm\\finl\\platform\\adm-suite\\foundation\\services\\target\\services-1.0-SNAPSHOT.jar", "C:\\Users\\vasudvis\\sdm\\lib\\outerbay-services.jar");


    }

    public static void printDiff(String file1, String file2) throws IOException {

        Set<String> fileList1 = getContents(file1);
        Set<String> fileList2 = getContents(file2);
        Set<String> common = new HashSet<>();
        for(String contentFilePath : fileList1){
            if(fileList2.contains(contentFilePath)){
               common.add(contentFilePath);
            }
        }

        fileList1.removeAll(common);
        fileList2.removeAll(common);

        print(file1, fileList1);

        print(file2, fileList2);
    }

    public static void print(String fileName, Set<String> paths){
        System.out.println("### " + fileName + " - " + paths.size());
         Set<String> sortSet = new TreeSet<>();
        sortSet.addAll(paths);

        for (String path : sortSet){
            System.out.println(">> " + path);
        }
    }


    public static Set<String> getContents(String jarFilePath) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe" ,"/c", "jar -tf " + jarFilePath );

        builder.redirectErrorStream(true);
        Process process = builder.start();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String line = null;
        Set<String> fileSet = new HashSet<>();
        while((line = bufferedReader.readLine()) != null){
            fileSet.add(line);
        }
        return fileSet;
    }

}
