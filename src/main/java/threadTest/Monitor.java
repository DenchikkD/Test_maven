package threadTest;

import java.io.File;

/**
 * Created by Iliren on 06.10.2016.
 */
public class Monitor {
    private File fileName1;
    private File fileName2;

    public Monitor() {
        fileName1 = new File("D:\\progects/Test_maven/FileDirectory/fileName1.txt");
        fileName2 = new File("D:\\progects/Test_maven/FileDirectory/fileName2.txt");
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        ThreadCreator threadCreator = new ThreadCreator(monitor.fileName1);
        ThreadWriter threadWriter = new ThreadWriter(monitor.fileName1, monitor.fileName2);
        threadWriter.setDaemon(true);

        threadWriter.start();

        threadCreator.start();
        while (threadCreator.isAlive()) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}
