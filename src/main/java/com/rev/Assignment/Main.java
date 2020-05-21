package com.rev.Assignment;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    //STRING PROCESS


    public File FileRead(File fname) throws IOException {

        String fileContent = "";
        FileReader readFile = new FileReader(fname.getPath());
        Scanner scan = new Scanner(readFile);

        while (scan.hasNextLine()) {
            fileContent = fileContent + scan.nextLine();

        }
        System.out.println(fileContent);
        String processedFile = ProcessString(fileContent);
        readFile.close();
        FileWriter fileWrite = new FileWriter(fname);
        fileWrite.write(processedFile);
        fileWrite.close();

        File zip = zip(fname);
        return zip;
//        return fname;
    }


    public String ProcessString(String inputStr) {

        String buffer1 = "";  //null string

        //check for special char
        inputStr = inputStr.replaceAll("[^a-zA-Z0-9.\\s]", "").replace("\n", "");

        String[] words = inputStr.split(" ");
        for (String s : words) {
            s = s.trim();
            if (s.length() > 0) {
                buffer1 += s;
                buffer1 += (" ");
            }
        }


        if (buffer1.contains(".")) {
            buffer1 = buffer1.replace(".", ".\n");
        }


        String aftern[] = buffer1.split("\n");


        String sb2 = "";
        for (String an : aftern) {
            String h = an.trim();
            try {

                String h1 = h.substring(0, 1).toUpperCase();
                h1 += h.substring(1, h.length()) + "\n";
                sb2 += h1;

            } catch (Exception e) {

            }

        }

        return sb2;
    }

    public File zip(File file) throws IOException {
        List<String> srcFiles = Arrays.asList(file.getAbsolutePath());
        String zippedFile = file.getAbsolutePath().replace(file.getName(), "") + "compressed" +
                System.currentTimeMillis() + "_" + file.getName() + ".zip";
        System.out.println("--->" + srcFiles);
        FileOutputStream fos = new FileOutputStream(zippedFile);
        System.out.println("--->" + fos);
        File fileToZip = null;
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (String srcFile : srcFiles) {
            fileToZip = new File(srcFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
        return new File(zippedFile);
    }
}
//
//    public  static void main(String args[]) throws Exception
//    {
//        File f = new File("Assign.txt");
//        System.out.println(f.length());
//           Main m = new Main();
//            m.FileRead(f);
//        System.out.println(f.length());
////        System.out.println(new Main().ProcessString("us \"Quotes of the Day\" for each date are lis#ted,^ a%d wh\n" +
////                "\n" +
////                "ere\n" +
////                " registered us;ers .can make sugg"));
//
//    }

