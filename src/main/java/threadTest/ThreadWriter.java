package threadTest;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Iliren on 06.10.2016.
 */
public class ThreadWriter extends Thread {

    private File fileName1;
    private File fileName2;
    FileReader fileReader;
    FileWriter fileWriter;
    Scanner scn;

    public ThreadWriter(File fileName1, File fileName2) {
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
        try {

            fileWriter = new FileWriter(fileName2, true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        synchronized (fileName1) {
            try {
                fileName1.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (true) {
            System.out.println("op");
            synchronized (fileName1) {
                System.out.println("writer work");
                try {
                    copyWithFileName1();
                    System.out.println("врайтер пішов спати");
                    fileName1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("writer close work");
            }
        }
    }

    public void copyWithFileName1() {
        try {
            fileReader = new FileReader(fileName1);
            scn = new Scanner(fileReader);
            fileWriter.write(scn.nextLine()+"\n");
            fileWriter.flush();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
