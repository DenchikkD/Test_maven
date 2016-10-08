package scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Denni on 10/8/2016.
 */
public class MainScanner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyScanner myScanner = new MyScanner(System.in);
//        System.out.println(myScanner.next());
        System.out.println(scanner.next());

    }
}
