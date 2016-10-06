package threadTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denni on 10/5/2016.
 */
public class TestThread {

    public static List<Integer> list = new ArrayList<>();
    public static Object object = new Object();

    public static void main(String[] args) {

        Thread thread = new ExempleThread(list, object);
        thread.start();

        synchronized (list) {
            try {
               list.wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main is work");
            for (int i = 51; i < 100; i++) {

                list.add(i);

            }
        }
        while (thread.isAlive()) {

        }
        System.out.println(list);
    }
}


