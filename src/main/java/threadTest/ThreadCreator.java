package threadTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Iliren on 06.10.2016.
 */
public class ThreadCreator extends Thread {
    private File fileName1;
    private boolean flag;
    Scanner scanner;
    FileWriter fileWriter;
    private String str = "";

    public ThreadCreator(File fileName1) {
        this.fileName1 = fileName1;
        flag = true;
        scanner = new Scanner(System.in);
        try {
            fileWriter = new FileWriter(fileName1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (flag) {
            synchronized (fileName1) {
                System.out.println("creator work");
                writeFileFromTerminal();
                fileName1.notify();

                try {
                    fileName1.wait(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("creator close work");
            }
        }
    }

    private void writeFileFromTerminal() {
        try {
            str = scanner.nextLine();
            if (!str.equals("Exit")) {
                fileWriter.write(str);
            } else {
                ThreadCreator.interrupted();
                flag = false;
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
