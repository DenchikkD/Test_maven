package scanner;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Denni on 10/8/2016.
 */
public class MainScanner {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("D:\\projects/test_maven/FileDirectory/fileName1.txt"));
        MyScanner myScanner = new MyScanner(new File("D:\\projects/test_maven/FileDirectory/fileName1.txt"));
//        MyScanner myScanner = new MyScanner(System.in);
//        Scanner intScaner = new Scanner(System.in);
//        System.out.println(intScaner.nextInt());
//        System.out.println(myScanner.nextInt());


        while (myScanner.hasNextInt()) {
            System.out.println(myScanner.nextInt());
        }
//        System.out.println(myScanner.nextInt());




    }
}
