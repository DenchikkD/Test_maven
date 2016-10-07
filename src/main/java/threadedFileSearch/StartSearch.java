package threadedFileSearch;

import java.io.File;

/**
 * Created by Iliren on 07.10.2016.
 */
public class StartSearch {


    public static void main(String[] args) {
        File searchRoot = new File("D:\\");
        String nameFile = "test";
//        if (searchRoot.isDirectory()) {
            Manager manager = new Manager(searchRoot, nameFile);
            Worker worker1 = new Worker(manager);
            Worker worker2 = new Worker(manager);
            Worker worker3 = new Worker(manager);
            worker1.setName("worker 1");
            worker2.setName("worker 2");
            worker3.setName("worker 3");

            worker1.start();
            worker2.start();
            worker3.start();


            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            worker1.setIsAliveWorker(false);
            worker2.setIsAliveWorker(false);
            worker3.setIsAliveWorker(false);

            if (manager.getFiendFiles().size() == 0) {
                System.out.println("Files not fiends!!!");
            } else {
                for (File file : manager.getFiendFiles()) {
                    System.out.println(file.getAbsoluteFile());
                }
            }

        }
    }

//}
