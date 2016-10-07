package threadedFileSearch;

import java.io.File;

/**
 * Created by Iliren on 07.10.2016.
 */
public class Worker extends Thread {

    private Manager manager;
    private boolean isAliveWorker = true;

    public Worker(Manager manager) {
        this.manager = manager;
    }

    public boolean isAliveWorker() {
        return isAliveWorker;
    }

    public void setIsAliveWorker(boolean aliveWorker) {
        this.isAliveWorker = aliveWorker;

    }


    @Override
    public void run() {

        while (isAliveWorker()) {
            System.out.println(currentThread().getName() + " work");

            File file = null;

            while (file == null) {
                try {
                    Thread.currentThread().sleep(1);
                    if (!isAliveWorker()) {
                        break;
                    }
                } catch (InterruptedException e) {

                    isAliveWorker = false;
                    e.printStackTrace();
                }
                file = manager.getResourses();
            }
            if (file != null) {
                if (file.getName().toLowerCase().contains(manager.getFileName())) {
                    System.out.println(Thread.currentThread().getName() +" " + file.getAbsolutePath());
                    manager.addFiendFiles(file);
                }

                if (file.isDirectory()&&file.listFiles()!=null) {
                    manager.addResourses(file.listFiles());
                }
            }
        }
    }
}