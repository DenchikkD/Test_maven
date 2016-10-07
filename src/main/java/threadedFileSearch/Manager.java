package threadedFileSearch;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Iliren on 07.10.2016.
 */
public class Manager {

    private String fileName;
    private List<File> resourses;
    private List<File> fiendFiles;

    public Manager(File roodDir, String fileName) {
        this.fileName = fileName;
        resourses = new LinkedList<>();
        resourses.add(roodDir);
        fiendFiles = new LinkedList<>();
    }

    public synchronized File getResourses() {
        if (!resourses.isEmpty()) {
            return resourses.remove(0);
        }
        return null;
    }

    public synchronized void addResourses(File[] files) {
        for (File file : files) {
            resourses.add(file);

        }
    }

    public  List<File> getFiendFiles() {
        return fiendFiles;
    }

    public synchronized void addFiendFiles(File fiendFile) {
        fiendFiles.add(fiendFile);

    }

    public String getFileName() {
        return fileName;
    }

}
