package threadTest;

import java.util.List;

public class ExempleThread extends Thread {
    private List<Integer> list;
    private Object object;

    public ExempleThread(List<Integer> list, Object object) {
        this.list = list;
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("exemple to wont work");
        synchronized (list) {
            System.out.println("exemple working");
            try {
                list.wait(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 50; i++) {
                list.add(i);
            }
        }
    }
}
